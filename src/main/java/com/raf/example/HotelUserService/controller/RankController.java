package com.raf.example.HotelUserService.controller;

import com.raf.example.HotelUserService.dto.RankDto;
import com.raf.example.HotelUserService.secutiry.CheckSecurity;
import com.raf.example.HotelUserService.secutiry.SecurityAspect;
import com.raf.example.HotelUserService.service.RankService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {

    private RankService rankService;
    private SecurityAspect securityAspect;

    public RankController(RankService rankService, SecurityAspect securityAspect) {
        this.rankService = rankService;
        this.securityAspect = securityAspect;
    }

    @PostMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<RankDto> addRank(@RequestHeader("authorization") String authorization,
                                           @RequestBody RankDto rankDto){
        return new ResponseEntity<>(rankService.save(rankDto), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<List<RankDto>> addAllRanks(@RequestHeader("authorization") String authorization,
                                                     @RequestBody List<RankDto> roomTypesDto){
        return new ResponseEntity<>(rankService.saveAll(roomTypesDto), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "rank configuration")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<RankDto> rankConfiguration(@RequestHeader("authorization") String authorization,
                                                     @RequestBody RankDto rankDto){
        System.out.println(rankDto.toString());
        return new ResponseEntity<>(rankService.rankConfiguration(rankDto), HttpStatus.OK);
    }
}
