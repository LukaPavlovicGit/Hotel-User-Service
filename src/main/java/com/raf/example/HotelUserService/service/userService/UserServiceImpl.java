package com.raf.example.HotelUserService.service.userService;

import com.raf.example.HotelUserService.dto.discount.DiscountDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import com.raf.example.HotelUserService.repository.UserRepository;
import com.raf.example.HotelUserService.repository.UserStatusRepository;
import com.raf.example.HotelUserService.service.tokenService.service.TokenService;
import com.raf.example.HotelUserService.service.userService.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private UserStatusRepository userStatusRepository;

    private JmsTemplate jmsTemplate; // injectuj preko konstruktora

    public UserServiceImpl(UserRepository userRepository, TokenService tokenService, UserStatusRepository userStatusRepository) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.userStatusRepository = userStatusRepository;
    }

    @Override
    public Page<ClientDto> findAllClients(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ManagerDto> findAllManagers(Pageable pageable) {
        return null;
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
        return null;
    }
}
