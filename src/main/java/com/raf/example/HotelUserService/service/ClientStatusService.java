package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.dto.ClientStatusDto;
import com.raf.example.HotelUserService.dto.DiscountDto;

public interface ClientStatusService {

    DiscountDto findDiscount(Long id);

    ClientStatusDto findClientStatusByClientId(Long userId);

    ClientStatusDto forbidAccess(Long id);

    ClientStatusDto allowAccess(Long id);
}
