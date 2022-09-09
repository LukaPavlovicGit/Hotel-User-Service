package com.raf.example.HotelUserService.service.userService;

import com.raf.example.HotelUserService.domain.Client;
import com.raf.example.HotelUserService.domain.ClientStatus;
import com.raf.example.HotelUserService.domain.Manager;
import com.raf.example.HotelUserService.domain.User;
import com.raf.example.HotelUserService.dto.clientStatus.ClientStatusDto;
import com.raf.example.HotelUserService.dto.discount.DiscountDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.repository.UserRepository;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
import com.raf.example.HotelUserService.service.tokenService.service.TokenService;
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

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private ClientStatusRepository clientStatusRepository;
    private Mapper mapper;

    private JmsTemplate jmsTemplate; // injectuj preko konstruktora

    public UserServiceImpl(UserRepository userRepository, TokenService tokenService, ClientStatusRepository clientStatusRepository, Mapper mapper, JmsTemplate jmsTemplate) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.clientStatusRepository = clientStatusRepository;
        this.mapper = mapper;
        this.jmsTemplate = jmsTemplate;
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
                        if(user.getRole().getName().equals("ROLE_USER"))
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

    @Override
    public DiscountDto findDiscount(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository.findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));

        return new DiscountDto(clientStatus.getDiscount());
    }

    @Override
    public ClientDto addClient(ClientCreateDto clientCreateDto) {
        Client client = mapper.clientCreateDtoToClient(clientCreateDto);
        userRepository.save(client);
        return mapper.clientToClientDto(client);
    }

    @Override
    public ManagerDto addManager(ManagerCreateDto managerCreateDto) {
        Manager manager = mapper.managerCreateDtoToManager(managerCreateDto);
        userRepository.save(manager);
        return mapper.managerToManagerDto(manager);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                                tokenRequestDto.getPassword())));
        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().getName());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }

    @Override
    public ClientStatusDto findClientStatusByClientId(Long clientId) {
        return clientStatusRepository.findClientStatusByUserId(clientId)
                .map(mapper::clientStatusToClientStatusDto)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
    }

    @Override
    public void forbidAccess(Long id) {

    }
}
