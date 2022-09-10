package com.raf.example.HotelUserService.service.profileConfigurationService;

import com.raf.example.HotelUserService.domain.Client;
import com.raf.example.HotelUserService.domain.User;
import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.payload.PayloadWrapper;
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
    public UserDto changeUsername(String token, UsernameDto usernameDto) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setUsername(usernameDto.getUsername());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changePassword(String token, PasswordDto passwordDto ) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setPassword(passwordDto.getPassword());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeFirstName(String token, FirstnameDto firstnameDto) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setFistName(firstnameDto.getFirstname());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeLastName(String token, LastnameDto lastnameDto) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setLastName(lastnameDto.getLastname());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeEmail(String token, EmailDto emailDto) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setEmail(emailDto.getEmail());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changePhoneNumber(String token, PhoneNumberDto phoneNumberDto) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setPhoneNumber(phoneNumberDto.getPhoneNumber());
        userRepository.save(user);

        return mapper.userToUserDto(user);
    }

    @Override
    public UserDto changeBirthday(String token, BirthdateDto birthdateDto) {
      /*  String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        User user = userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        user.setBirthdate(birthdateDto.getPhoneNumber());
        userRepository.save(user);

        return mapper.userToUserDto(user);*/
        return null;
    }

    @Override
    public ClientDto changeNumOfPassport(String token, PassportNumDto passportNumDto) {
        String payload = token.split("\\.")[1];
        String decodedJSON = new String(decoder.decode(payload));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PayloadWrapper payloadWrapper = gson.fromJson(decodedJSON, PayloadWrapper.class);
        Client client = (Client) userRepository.findById(payloadWrapper.getId())
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d does not exists.", payloadWrapper.getId())));
        client.setNumOfPassport(passportNumDto.getPassportNum());
        userRepository.save(client);

        return mapper.clientToClientDto(client);
    }

}
