package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.ClientStatusDto;
import com.raf.example.HotelUserService.dto.DiscountDto;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.service.ClientStatusService;
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
    public ResponseEntity<DiscountDto> getDiscount(@RequestHeader("authorization") String authorization,
                                                   @PathVariable("clientId") Long clientId) {
        return new ResponseEntity<>(clientStatusService.findDiscount(clientId), HttpStatus.OK);
    }

    @PutMapping("/block")
    @ApiOperation(value = "forbid access")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientStatusDto> forbidAccess(@RequestHeader("authorization") String authorization,
                                                        @RequestBody Long clientId){
        return new ResponseEntity<>(clientStatusService.forbidAccess(clientId), HttpStatus.OK);
    }

    @PutMapping("/unblock")
    @ApiOperation(value = "allow access")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientStatusDto> allowAccess(@RequestHeader("authorization") String authorization,
                                                       @RequestBody Long clientId){
        return new ResponseEntity<>(clientStatusService.allowAccess(clientId), HttpStatus.OK);
    }
}
