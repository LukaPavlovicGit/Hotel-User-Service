package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.dto.ClientIdDto;
import com.raf.example.HotelUserService.dto.IncrementReservationDto;
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

    ClientDto addClient(ClientCreateDto clientCreateDto);

    ManagerDto addManager(ManagerCreateDto managerCreateDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    ClientDto incrementNumberOfReservation(IncrementReservationDto incrementReservationDto);



}
