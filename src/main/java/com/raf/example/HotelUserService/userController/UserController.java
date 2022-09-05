package com.raf.example.HotelUserService.userController;

import com.raf.example.HotelUserService.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
}
