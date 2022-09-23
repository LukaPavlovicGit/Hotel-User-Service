package com.raf.example.HotelUserService.service.impl;

import com.raf.example.HotelUserService.domain.*;
import com.raf.example.HotelUserService.dto.DiscountDto;
import com.raf.example.HotelUserService.dto.MessageDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import com.raf.example.HotelUserService.exception.AccessForbidden;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.messageHelper.MessageHelper;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
import com.raf.example.HotelUserService.repository.RankRepository;
import com.raf.example.HotelUserService.repository.RoleRepository;
import com.raf.example.HotelUserService.repository.UserRepository;
import com.raf.example.HotelUserService.secutiry.tokenService.TokenService;
import com.raf.example.HotelUserService.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ClientStatusRepository clientStatusRepository;
    private RankRepository rankRepository;
    private Mapper mapper;
    private JmsTemplate jmsTemplate;

    private MessageHelper messageHelper;

    public UserServiceImpl(TokenService tokenService, UserRepository userRepository, RoleRepository roleRepository, ClientStatusRepository clientStatusRepository,
                           RankRepository rankRepository, Mapper mapper, JmsTemplate jmsTemplate, MessageHelper messageHelper) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.clientStatusRepository = clientStatusRepository;
        this.rankRepository = rankRepository;
        this.mapper = mapper;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(mapper::userToUserDto);
    }

    @Override
    public UserDto findUserById(Long id) {
        return userRepository.findById(id)
                .map(mapper::userToUserDto)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", id)));
    }

    @Override
    public Page<ClientDto> findAllClients(Pageable pageable) {
        List<ClientDto> clients = new ArrayList<>();
        userRepository.findAll(pageable)
                .forEach( user -> {
                        if(user.getRole().getName().equals("ROLE_CLIENT"))
                            clients.add(mapper.clientToClientDto((Client) user));
                    }
                );
        Page<ClientDto> page = new PageImpl<>(clients);
        return page;
    }

    @Override
    public Page<ManagerDto> findAllManagers(Pageable pageable) {
        List<ManagerDto> managers = new ArrayList<>();
        userRepository.findAll(pageable)
                .forEach( user -> {
                            if(user.getRole().getName().equals("ROLE_MANAGER"))
                                managers.add(mapper.managerToManagerDto((Manager) user));
                        }
                );
        Page<ManagerDto> page = new PageImpl<>(managers);
        return page;
    }

    public ClientDto save(ClientCreateDto clientCreateDto) {
        Role role = roleRepository.findRoleByName("ROLE_CLIENT")
                .orElseThrow(() -> new NotFoundException("Role with name: ROLE_CLIENT not found."));

        Client client = mapper.clientCreateDtoToClient(clientCreateDto);
        client.setRole(role);
        userRepository.save(client);

        Rank rank = rankRepository.findByName("BRONZE").orElseThrow(() -> new NotFoundException(""));
        ClientStatus clientStatus = new ClientStatus(client.getId(), rank);
        clientStatusRepository.save(clientStatus);

        sendEmail(new MessageDto("account_activation", client.getFirstName(), client.getLastName(),
                "http://localhost:8080/api/users/activation/"+client.getId(),client.getEmail()));

        return mapper.clientToClientDto(client);
    }

    public ManagerDto save(ManagerCreateDto managerCreateDto) {
        Role role = roleRepository.findRoleByName("ROLE_MANAGER")
                .orElseThrow(() -> new NotFoundException("Role with name: ROLE_MANAGER not found."));
        Manager manager = mapper.managerCreateDtoToManager(managerCreateDto);
        manager.setRole(role);
        userRepository.save(manager);

        sendEmail(new MessageDto("account_activation", manager.getFirstName(), manager.getLastName(),
                "http://localhost:8080/api/users/activation/"+manager.getId(),manager.getEmail()));

        return mapper.managerToManagerDto(manager);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String.format("User with username: %s and password: %s not found.",
                        tokenRequestDto.getUsername(), tokenRequestDto.getPassword())));
        if(user instanceof  Client){
            Optional<ClientStatus> clientStatusOptional = clientStatusRepository.findClientStatusByUserId(user.getId());
            if(clientStatusOptional.isPresent()){
                ClientStatus clientStatus = clientStatusOptional.get();
                if(clientStatus.getAccessForbidden() == true){
                    throw new AccessForbidden(String.format("Access forbidden for client with username: %s.", tokenRequestDto.getUsername()));
                }
            }
        }

        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().getName());
        claims.put("email", user.getEmail());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }

    @Override
    public DiscountDto getDiscount(Long userId) {
        ClientStatus clientStatus = clientStatusRepository.findClientStatusByUserId(userId).orElseThrow(() -> new NotFoundException(""));
        return new DiscountDto(clientStatus.getDiscount());
    }

    @Override
    public void activate(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String
                .format("User with user id: %d not found.", userId)));
        user.setActivated(true);
        userRepository.save(user);
    }

    @Override
    public void sendEmail(MessageDto messageDto) {
        jmsTemplate.convertAndSend("send_mail_queue", messageHelper.createTextMessage(messageDto));
    }

    @Override
    public ClientDto incrementNumOfReservation(Long clientId) {
        Client client = (Client) userRepository.findById(clientId).orElseThrow(() -> new NotFoundException(String.format("Client with clientId %d not found", clientId)));
        client.setNumOfReservation(client.getNumOfReservation() + 1);
        userRepository.save(client);
        return mapper.clientToClientDto(client);
    }

    @Override
    public ClientDto decrementNumOfReservation(Long clientId) {
        Client client = (Client) userRepository.findById(clientId).orElseThrow(() -> new NotFoundException(String.format("Client with clientId %d not found", clientId)));
        client.setNumOfReservation(client.getNumOfReservation() - 1);
        userRepository.save(client);
        return mapper.clientToClientDto(client);
    }

}
