package com.raf.example.HotelUserService.service.clientStatusService;

import com.raf.example.HotelUserService.dto.clientStatus.ClientStatusDto;
import com.raf.example.HotelUserService.dto.discount.DiscountDto;

public interface ClientStatusService {

    DiscountDto findDiscount(Long id);

    ClientStatusDto findClientStatusByClientId(Long userId);

    ClientStatusDto forbidAccess(Long id);

    ClientStatusDto allowAccess(Long id);
}
