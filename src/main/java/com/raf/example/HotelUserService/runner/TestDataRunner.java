package com.raf.example.HotelUserService.runner;
import com.raf.example.HotelUserService.domain.*;
import com.raf.example.HotelUserService.repository.RoleRepository;
import com.raf.example.HotelUserService.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public TestDataRunner(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert roles
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleManager = new Role("ROLE_MANAGER");
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
        roleRepository.save(roleManager);
        //Insert admin
        Admin admin = new Admin();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setFistName("Luka");
        admin.setLastName("Pavlovic");
        admin.setPhoneNumber("0641234567");
        admin.setBirthdate(new Date());
        admin.setRole(roleAdmin);

        User u1 = new Client();
        u1.setEmail("u1@gmail.com");
        u1.setUsername("u1");
        u1.setPassword("u1");
        u1.setFistName("Luka");
        u1.setLastName("Pavlovic2323");
        u1.setPhoneNumber("0641234567");
        u1.setBirthdate(new Date());
        u1.setRole(roleUser);

        User u2 = new Client();
        u2.setEmail("u2@gmail.com");
        u2.setUsername("u2");
        u2.setPassword("u2");
        u2.setFistName("Luka");
        u2.setLastName("Pavlovicwwww");
        u2.setPhoneNumber("0641234567");
        u2.setBirthdate(new Date());
        u2.setRole(roleUser);

        User u3 = new Manager();
        u3.setEmail("u3@gmail.com");
        u3.setUsername("u3");
        u3.setPassword("u3");
        u3.setFistName("aaaaa");
        u3.setLastName("1111111");
        u3.setPhoneNumber("0641234567");
        u3.setBirthdate(new Date());
        u3.setRole(roleManager);
        ((Manager) u3).setHireDate(new Date());
        ((Manager) u3).setHotelName("hotel2");

        User u4 = new Manager();
        u4.setEmail("u4@gmail.com");
        u4.setUsername("u4");
        u4.setPassword("u4");
        u4.setFistName("bbbbbb");
        u4.setLastName("222222222");
        u4.setPhoneNumber("0641234567");
        u4.setBirthdate(new Date());
        u4.setRole(roleManager);
        ((Manager) u4).setHireDate(new Date());
        ((Manager) u4).setHotelName("hotel1");



        userRepository.save(admin);
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);
    }
}
