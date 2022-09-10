package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.*;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.service.profileConfigurationService.ProfileConfigurationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserProfileConfiguration")
public class UserProfileConfigurationController {
    private ProfileConfigurationService profileConfigurationService;

    public UserProfileConfigurationController(ProfileConfigurationService profileConfigurationService) {
        this.profileConfigurationService = profileConfigurationService;
    }

    @PutMapping("/changeUsername")
    @ApiOperation(value = "change username")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeUsername(@RequestHeader("authorization") String authorization, UsernameDto usernameDto){
        return new ResponseEntity<>(profileConfigurationService.changeUsername(authorization.split(" ")[1], usernameDto), HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    @ApiOperation(value = "change password")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changePassword(@RequestHeader("authorization") String authorization, PasswordDto passwordDto){
        return new ResponseEntity<>(profileConfigurationService.changePassword(authorization.split(" ")[1], passwordDto), HttpStatus.OK);
    }

    @PutMapping("/changeFirstname")
    @ApiOperation(value = "change firstname")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeFirstName(@RequestHeader("authorization") String authorization, FirstnameDto firstnameDto){
        return new ResponseEntity<>(profileConfigurationService.changeFirstName(authorization.split(" ")[1], firstnameDto), HttpStatus.OK);
    }

    @PutMapping("/changeLastname")
    @ApiOperation(value = "change lastname")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeLastName(@RequestHeader("authorization") String authorization, LastnameDto lastnameDto){
        return new ResponseEntity<>(profileConfigurationService.changeLastName(authorization.split(" ")[1], lastnameDto), HttpStatus.OK);
    }

    @PutMapping("/changeEmail")
    @ApiOperation(value = "change email")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeEmail(@RequestHeader("authorization") String authorization, EmailDto emailDto){
        return new ResponseEntity<>(profileConfigurationService.changeEmail(authorization.split(" ")[1], emailDto), HttpStatus.OK);
    }

    @PutMapping("/changePhoneNumber")
    @ApiOperation(value = "change phone number")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changePhoneNumber(@RequestHeader("authorization") String authorization, PhoneNumberDto phoneNumberDto){
        return new ResponseEntity<>(profileConfigurationService.changePhoneNumber(authorization.split(" ")[1], phoneNumberDto), HttpStatus.OK);
    }

    @PutMapping("/changeBirthdate")
    @ApiOperation(value = "change birthdate")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeBirthdate(@RequestHeader("authorization") String authorization, BirthdateDto birthdateDto){
        return new ResponseEntity<>(profileConfigurationService.changeBirthday(authorization.split(" ")[1], birthdateDto), HttpStatus.OK);
    }

    @PutMapping("/changePassportNumber")
    @ApiOperation(value = "change passport number")
    @CheckSecurity(roles = {"ROLE_CLIENT"})
    public ResponseEntity<ClientDto> changeNumOfPassport(@RequestHeader("authorization") String authorization, PassportNumDto passportNumDto){
        return new ResponseEntity<>(profileConfigurationService.changeNumOfPassport(authorization.split(" ")[1], passportNumDto), HttpStatus.OK);
    }
}