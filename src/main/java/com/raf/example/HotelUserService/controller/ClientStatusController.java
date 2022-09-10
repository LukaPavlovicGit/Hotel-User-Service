package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.domain.ClientStatus;
import com.raf.example.HotelUserService.dto.clientStatus.ClientStatusDto;
import com.raf.example.HotelUserService.dto.discount.DiscountDto;
import com.raf.example.HotelUserService.dto.user.UserDto;
import com.raf.example.HotelUserService.dto.userFields.UsernameDto;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.service.clientStatusService.ClientStatusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientStatus")
public class ClientStatusController {
    private ClientStatusService clientStatusService;

    public ClientStatusController(ClientStatusService clientStatusService){
        this.clientStatusService = clientStatusService;
    }

    @GetMapping("/discount/{clientId}")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<DiscountDto> getDiscount(@RequestHeader("authorization") String authorization,
                                                        @PathVariable("clientId") Long clientId) {
        return new ResponseEntity<>(clientStatusService.findDiscount(clientId), HttpStatus.OK);
    }

    @PutMapping("/forbidAccess/{clientId}")
    @ApiOperation(value = "forbid access")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientStatusDto> forbidAccess(@RequestHeader("authorization") String authorization,
                                                            @PathVariable("clientId") Long clientId){
        return new ResponseEntity<>(clientStatusService.forbidAccess(clientId), HttpStatus.OK);
    }

    @PutMapping("/allowAccess/{clientId}")
    @ApiOperation(value = "allow access")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientStatusDto> allowAccess(@RequestHeader("authorization") String authorization,
                                                            @PathVariable("clientId") Long clientId){
        return new ResponseEntity<>(clientStatusService.allowAccess(clientId), HttpStatus.OK);
    }
}
