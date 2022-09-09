package com.raf.example.HotelUserService.service.userService;

import com.raf.example.HotelUserService.domain.Client;
import com.raf.example.HotelUserService.domain.Manager;
import com.raf.example.HotelUserService.domain.User;
import com.raf.example.HotelUserService.dto.discount.DiscountDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.repository.UserRepository;
import com.raf.example.HotelUserService.repository.UserStatusRepository;
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
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private UserStatusRepository userStatusRepository;
    private Mapper mapper;

    private JmsTemplate jmsTemplate; // injectuj preko konstruktora

    public UserServiceImpl(UserRepository userRepository, TokenService tokenService, UserStatusRepository userStatusRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.userStatusRepository = userStatusRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(mapper::userToUserDto);
    }

    @Override
    public UserDto findById(Long id) {
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
    public DiscountDto findDiscount(Long id) {
        return null;
    }

    @Override
    public ClientDto addClient(ClientCreateDto clientCreateDto) {
        return null;
    }

    @Override
    public ManagerDto addManager(ManagerCreateDto managerCreateDto) {
        return null;
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
}
