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

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    /*    @ApiImplicitParams({
                @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
                @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
                @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                        value = "Sorting criteria in the format: property(,asc|desc). " +
                                "Default sort order is ascending. " +
                                "Multiple sort criteria are supported.")})*/
    @GetMapping
    @ApiOperation(value = "get all users")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("authorization") String authorization,
                                                         Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "get user by id")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<UserDto> getUserById(@RequestHeader("authorization") String authorization,
                                                        @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/clients")
    @ApiOperation(value = "get all clients")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<Page<ClientDto>> getClients(@RequestHeader("authorization") String authorization,
                                                        Pageable pageable){
        return new ResponseEntity<>(userService.findAllClients(pageable), HttpStatus.OK);
    }

    @GetMapping("/managers")
    @ApiOperation(value = "get all managers")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    public ResponseEntity<Page<ManagerDto>> getManagers(@RequestHeader("authorization") String authorization,
                                                      Pageable pageable){
        return new ResponseEntity<>(userService.findAllManagers(pageable), HttpStatus.OK);
    }

    @PostMapping("/registration/client")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    @ApiOperation(value = "client registration")
    public ResponseEntity<ClientDto> registerClient(@RequestHeader("authorization") String authorization,
                                                        @RequestBody @Valid ClientCreateDto clientCreateDto) {
        return new ResponseEntity<>(userService.addClient(clientCreateDto), HttpStatus.CREATED);
    }

    @PostMapping("/registration/manager")
    @CheckSecurity(roles = {"ROLE_MANAGER", "ROLE_ADMIN"})
    @ApiOperation(value = "manager registration")
    public ResponseEntity<ManagerDto> registerManager(@RequestHeader("authorization") String authorization,
                                                        @RequestBody @Valid ManagerCreateDto managerCreateDto) {
        return new ResponseEntity<>(userService.addManager(managerCreateDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @ApiOperation(value = "login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}/discount")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getDiscount(id), HttpStatus.OK);
    }
}
