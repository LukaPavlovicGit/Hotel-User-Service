package com.raf.example.HotelUserService.service.profileConfigurationService;
import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.*;

public interface ProfileConfigurationService {

    UserDto changeUsername(Long userId, UsernameDto usernameDto);
    UserDto changePassword(Long userId, PasswordDto passwordDto);
    UserDto changeFirstName(Long userId, FirstnameDto firstnameDto);
    UserDto changeLastName(Long userId, LastnameDto lastnameDto);
    UserDto changeEmail(Long userId, EmailDto emailDto);
    UserDto changePhoneNumber(Long userId, PhoneNumberDto phoneNumberDto);
    UserDto changeBirthday(Long userId, BirthdateDto birthdateDto);
    ClientDto changeNumOfPassport(Long userId, PassportNumDto passportNumDto);
}
/*
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String fistName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private Date birthdate;*/