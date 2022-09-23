package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.dto.DiscountDto;
import com.raf.example.HotelUserService.dto.MessageDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    UserDto findUserById(Long id);

    Page<ClientDto> findAllClients(Pageable pageable);

    Page<ManagerDto> findAllManagers(Pageable pageable);

    ClientDto save(ClientCreateDto clientCreateDto);

    ManagerDto save(ManagerCreateDto managerCreateDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    DiscountDto getDiscount(Long userId);

    void activate(Long id);

    void sendEmail(MessageDto messageDto);

    ClientDto incrementNumOfReservation(Long clientId);
    ClientDto decrementNumOfReservation(Long clientId);


}
