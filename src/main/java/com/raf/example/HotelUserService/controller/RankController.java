package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.RankDto;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.service.RankService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rank")
public class RankController {

    private RankService rankService;

    public RankController(RankService rankService){
        this.rankService = rankService;
    }

    @PutMapping("/rankConfiguration/")
    @ApiOperation(value = "rank configuration")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<RankDto> rankConfiguration(@RequestHeader("authorization") String authorization,
                                                        @RequestBody @Valid RankDto rankDto){
        return new ResponseEntity<>(rankService.rankConfiguration(rankDto), HttpStatus.OK);
    }
}
