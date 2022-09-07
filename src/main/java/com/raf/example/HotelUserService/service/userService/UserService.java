package com.raf.example.HotelUserService.service.userService;

import com.raf.example.HotelUserService.dto.discount.DiscountDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserDto> findAll(Pageable pageable);

    DiscountDto findDiscount(Long id);

    ClientDto addClient(ClientCreateDto clientCreateDto);

    ManagerDto addManager(ManagerCreateDto managerCreateDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}
