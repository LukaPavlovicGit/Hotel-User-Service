package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.domain.Client;
import com.raf.example.HotelUserService.domain.Manager;
import com.raf.example.HotelUserService.domain.User;
import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.ManagerDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Base64;

@Service
@Transactional
public class ProfileConfigurationService {
    private Base64.Decoder decoder = Base64.getUrlDecoder();
    private UserRepository userRepository;
    private Mapper mapper;

    public ProfileConfigurationService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ClientDto updateClient(Long clientId, ClientDto clientDto) {
        User user = userRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
        Client update = mapper.clientDtoToClient(clientDto);
        update.setId(clientId);
        update.setNumOfReservation(((Client)user).getNumOfReservation());
        update.setRole(user.getRole());
        update.setActivated(user.getActivated());
        userRepository.save(update);
        return clientDto;
    }

    public ManagerDto updateManager(Long managerId, ManagerDto managerDto) {
        User user = userRepository.findById(managerId)
                .orElseThrow(() -> new NotFoundException(String.format("Manager with id: %d does not exists.", managerId)));
        Manager update = mapper.managerDtoToManager(managerDto);
        update.setId(managerId);
        update.setRole(user.getRole());
        update.setActivated(user.getActivated());
        userRepository.save(update);
        return managerDto;
    }

    public UserDto updateAdmin(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("Admin with id: %d does not exists.", userId)));
        User update = mapper.userDtoToUser(userDto);
        update.setId(userId);
        update.setRole(user.getRole());
        update.setActivated(user.getActivated());
        userRepository.save(update);
        return userDto;
    }

}
