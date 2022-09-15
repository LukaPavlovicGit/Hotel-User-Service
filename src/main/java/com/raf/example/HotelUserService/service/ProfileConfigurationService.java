package com.raf.example.HotelUserService.service;
import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.ManagerDto;
import com.raf.example.HotelUserService.dto.user.UserDto;

public interface ProfileConfigurationService {

    ClientDto updateClient(Long clientId, ClientDto clientDto);
    ManagerDto updateManager(Long managerId, ManagerDto managerDto);
    UserDto updateAdmin(Long userId, UserDto userDto);
}
