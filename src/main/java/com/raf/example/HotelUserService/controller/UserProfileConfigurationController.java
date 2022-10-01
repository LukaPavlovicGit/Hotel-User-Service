package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.user.ClientDto;
import com.raf.example.HotelUserService.dto.user.ManagerDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.secutiry.SecurityAspect;
import com.raf.example.HotelUserService.service.ProfileConfigurationService;
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
    @PutMapping("/updateClient")
    @ApiOperation(value = "client update")
    @CheckSecurity(roles = {"ROLE_CLIENT"})
    public ResponseEntity<ClientDto> updateClient(@RequestHeader("authorization") String authorization,
                                                  @RequestBody ClientDto clientDto){
        Long clientId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.updateClient(clientId, clientDto), HttpStatus.OK);
    }

    @PutMapping("/updateManager")
    @ApiOperation(value = "manager update")
    @CheckSecurity(roles = {"ROLE_MANAGER"})
    public ResponseEntity<ManagerDto> updateManager(@RequestHeader("authorization") String authorization,
                                                    @RequestBody ManagerDto managerDto){
        Long managerId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.updateManager(managerId, managerDto), HttpStatus.OK);
    }

    @PutMapping("/updateAdmin")
    @ApiOperation(value = "admin update")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<UserDto> adminUpdate(@RequestHeader("authorization") String authorization,
                                               @RequestBody UserDto userDto){
        Long userId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(profileConfigurationService.updateAdmin(userId, userDto), HttpStatus.OK);
    }

}