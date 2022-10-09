package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.DiscountDto;
import com.raf.example.HotelUserService.dto.token.TokenRequestDto;
import com.raf.example.HotelUserService.dto.token.TokenResponseDto;
import com.raf.example.HotelUserService.dto.user.*;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "get all users")
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_MANAGER"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("authorization") String authorization,
                                                     @ApiIgnore Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "get user by id")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/clients") // NE KORISTI SE NA KLIJENTSKOJ STRANI
    @ApiOperation(value = "get all clients")
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_MANAGER"})
    public ResponseEntity<List<ClientDto>> getClients(@RequestHeader("authorization") String authorization,
                                                      Pageable pageable){
        return new ResponseEntity<>(userService.findAllClients(pageable), HttpStatus.OK);
    }

    @GetMapping("/managers")// NE KORISTI SE NA KLIJENTSKOJ STRANI
    @ApiOperation(value = "get all managers")
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_MANAGER"})
    public ResponseEntity<List<ManagerDto>> getManagers(@RequestHeader("authorization") String authorization,
                                                      Pageable pageable){
        return new ResponseEntity<>(userService.findAllManagers(pageable), HttpStatus.OK);
    }

    @PostMapping("/registration/client")
    @ApiOperation(value = "client registration")
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientCreateDto clientCreateDto) {
        return new ResponseEntity<>(userService.save(clientCreateDto), HttpStatus.CREATED);
    }

    @PostMapping("/registration/manager")
    @ApiOperation(value = "manager registration")
    public ResponseEntity<ManagerDto> registerManager(@RequestBody ManagerCreateDto managerCreateDto) {
        return new ResponseEntity<>(userService.save(managerCreateDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @ApiOperation(value = "login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}/discount")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getDiscount(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Activate account")
    @GetMapping("/activation/{userId}")
    public ResponseEntity<Void> activateAccount(@PathVariable("userId") Long userId){
        userService.activate(userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @ApiOperation(value = "Increment reservation")
    @PostMapping("/incrementReservation/{clientId}")
    public void incrementReservation(@PathVariable("clientId") Long clientId){
        userService.incrementNumOfReservation(clientId);
    }
    @ApiOperation(value = "Decrement reservation")
    @PostMapping("/decrementReservation/{clientId}")
    public void decrementReservation(@PathVariable("clientId") Long clientId){
        userService.decrementNumOfReservation(clientId);
    }
}
