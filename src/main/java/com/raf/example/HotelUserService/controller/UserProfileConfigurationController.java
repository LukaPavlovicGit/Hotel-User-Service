package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.*;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.secutiry.SecurityAspect;
import com.raf.example.HotelUserService.service.profileConfigurationService.ProfileConfigurationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserProfileConfiguration")
public class UserProfileConfigurationController {
    private ProfileConfigurationService profileConfigurationService;
    private SecurityAspect securityAspect;

    public UserProfileConfigurationController(ProfileConfigurationService profileConfigurationService, SecurityAspect securityAspect) {
        this.profileConfigurationService = profileConfigurationService;
        this.securityAspect = securityAspect;
    }

    @PutMapping("/changeUsername")
    @ApiOperation(value = "change username")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeUsername(@RequestHeader("authorization") String authorization, UsernameDto usernameDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changeUsername(userId, usernameDto), HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    @ApiOperation(value = "change password")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changePassword(@RequestHeader("authorization") String authorization, PasswordDto passwordDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changePassword(userId, passwordDto), HttpStatus.OK);
    }

    @PutMapping("/changeFirstname")
    @ApiOperation(value = "change firstname")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeFirstName(@RequestHeader("authorization") String authorization, FirstnameDto firstnameDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changeFirstName(userId, firstnameDto), HttpStatus.OK);
    }

    @PutMapping("/changeLastname")
    @ApiOperation(value = "change lastname")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeLastName(@RequestHeader("authorization") String authorization, LastnameDto lastnameDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changeLastName(userId, lastnameDto), HttpStatus.OK);
    }

    @PutMapping("/changeEmail")
    @ApiOperation(value = "change email")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeEmail(@RequestHeader("authorization") String authorization, EmailDto emailDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changeEmail(userId, emailDto), HttpStatus.OK);
    }

    @PutMapping("/changePhoneNumber")
    @ApiOperation(value = "change phone number")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changePhoneNumber(@RequestHeader("authorization") String authorization, PhoneNumberDto phoneNumberDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changePhoneNumber(userId, phoneNumberDto), HttpStatus.OK);
    }

    @PutMapping("/changeBirthdate")
    @ApiOperation(value = "change birthdate")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> changeBirthdate(@RequestHeader("authorization") String authorization, BirthdateDto birthdateDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changeBirthday(userId, birthdateDto), HttpStatus.OK);
    }

    @PutMapping("/changePassportNumber")
    @ApiOperation(value = "change passport number")
    @CheckSecurity(roles = {"ROLE_CLIENT"})
    public ResponseEntity<ClientDto> changeNumOfPassport(@RequestHeader("authorization") String authorization, PassportNumDto passportNumDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.changeNumOfPassport(userId, passportNumDto), HttpStatus.OK);
    }
}