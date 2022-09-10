package com.raf.example.HotelUserService.service.profileConfigurationService;
import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.*;

public interface ProfileConfigurationService {

    UserDto changeUsername(String token, UsernameDto usernameDto);
    UserDto changePassword(String token, PasswordDto passwordDto);
    UserDto changeFirstName(String token, FirstnameDto firstnameDto);
    UserDto changeLastName(String token, LastnameDto lastnameDto);
    UserDto changeEmail(String token, EmailDto emailDto);
    UserDto changePhoneNumber(String token, PhoneNumberDto phoneNumberDto);
    UserDto changeBirthday(String token, BirthdateDto birthdateDto);
    ClientDto changeNumOfPassport(String token, PassportNumDto passportNumDto);
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