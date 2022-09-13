package com.raf.example.HotelUserService.service.profileConfigurationService;

import com.raf.example.HotelUserService.domain.Client;
import com.raf.example.HotelUserService.domain.Manager;
import com.raf.example.HotelUserService.domain.User;
import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.dto.PayloadWrapper;
import com.raf.example.HotelUserService.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Base64;

@Service
@Transactional
public class ProfileConfigurationServiceImpl implements ProfileConfigurationService {
    private Base64.Decoder decoder = Base64.getUrlDecoder();
    private UserRepository userRepository;
    private Mapper mapper;

    public ProfileConfigurationServiceImpl(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDto changeUsername(Long userId, UsernameDto usernameDto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setUsername(usernameDto.getUsername());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changePassword(Long userId, PasswordDto passwordDto ) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setPassword(passwordDto.getPassword());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeFirstName(Long userId, FirstnameDto firstnameDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setFirstName(firstnameDto.getFirstname());
        userRepository.save(user);
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeLastName(Long userId, LastnameDto lastnameDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setLastName(lastnameDto.getLastname());
        userRepository.save(user);
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeEmail(Long userId, EmailDto emailDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setEmail(emailDto.getEmail());
        userRepository.save(user);
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changePhoneNumber(Long userId, PhoneNumberDto phoneNumberDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setPhoneNumber(phoneNumberDto.getPhoneNumber());
        userRepository.save(user);
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeBirthday(Long userId, BirthdateDto birthdateDto) {
      /*
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", userId)));
        user.setBirthdate(birthdateDto.getPhoneNumber());
        userRepository.save(user);
        return mapper.userToUserDto(user);*/
        return null;
    }

    @Override
    public ClientDto changeNumOfPassport(Long userId, PassportNumDto passportNumDto) {
        Client client = (Client) userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.",userId)));
        client.setNumOfPassport(passportNumDto.getPassportNum());
        userRepository.save(client);

        return mapper.clientToClientDto(client);
    }

}
