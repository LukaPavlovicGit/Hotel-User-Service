package com.raf.example.HotelUserService.runner;
import com.raf.example.HotelUserService.domain.*;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
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
    private ClientStatusRepository clientStatusRepository;

    public TestDataRunner(RoleRepository roleRepository, UserRepository userRepository, ClientStatusRepository clientStatusRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.clientStatusRepository = clientStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        clientStatusRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();
        //Insert roles
        Role roleClient = new Role("ROLE_CLIENT");
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleManager = new Role("ROLE_MANAGER");
        roleRepository.save(roleClient);
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

        Client u1 = new Client();
        //eyJhbGciOiJIUzUxMiJ9.eyJpZCI6Miwicm9sZSI6IlJPTEVfVVNFUiJ9.RA-Weml4f3pt9sTFnG58M5KyJDbp9hEa-1VPcuZ_UFNWS56eJrN-23Xj28kfF0DXKoxK6rsgReYtjuRIddQPDw
        //eyJhbGciOiJIUzUxMiJ9.eyJpZCI6Miwicm9sZSI6IlJPTEVfVVNFUiJ9.RA-Weml4f3pt9sTFnG58M5KyJDbp9hEa-1VPcuZ_UFNWS56eJrN-23Xj28kfF0DXKoxK6rsgReYtjuRIddQPDw
        u1.setEmail("u1@gmail.com");
        u1.setUsername("u1");
        u1.setPassword("u1");
        u1.setFistName("Luka");
        u1.setLastName("Pavlovic2323");
        u1.setPhoneNumber("0641234567");
        u1.setBirthdate(new Date());
        u1.setRole(roleClient);
        u1.setNumOfPassport("123553431");

        Client u2 = new Client();
        //eyJhbGciOiJIUzUxMiJ9.eyJpZCI6Mywicm9sZSI6IlJPTEVfVVNFUiJ9.XNw7kEEkizwJjQh2vDGuysnz_mvMs423VkERFMWj4z-HX-NQhfIjwAoZdJpuhzxtrmNjlWa1odIGHQ8H2ONS_A
        u2.setEmail("u2@gmail.com");
        u2.setUsername("u2");
        u2.setPassword("u2");
        u2.setFistName("Luka");
        u2.setLastName("Pavlovicwwww");
        u2.setPhoneNumber("0641234567");
        u2.setBirthdate(new Date());
        u2.setRole(roleClient);
        u2.setNumOfPassport("33255123");

        Manager u3 = new Manager();
        u3.setEmail("u3@gmail.com");
        u3.setUsername("u3");
        u3.setPassword("u3");
        u3.setFistName("aaaaa");
        u3.setLastName("1111111");
        u3.setPhoneNumber("0641234567");
        u3.setBirthdate(new Date());
        u3.setRole(roleManager);
        u3.setHireDate(new Date());
        u3.setHotelName("hotel2");

        Manager u4 = new Manager();
        u4.setEmail("u4@gmail.com");
        u4.setUsername("u4");
        u4.setPassword("u4");
        u4.setFistName("bbbbbb");
        u4.setLastName("222222222");
        u4.setPhoneNumber("0641234567");
        u4.setBirthdate(new Date());
        u4.setRole(roleManager);
        u4.setHireDate(new Date());
        u4.setHotelName("hotel1");

        ClientStatus u1Status = new ClientStatus(u1.getId());
        ClientStatus u2Status = new ClientStatus(u2.getId());

        userRepository.save(admin);
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);
        clientStatusRepository.save(u1Status);
        clientStatusRepository.save(u2Status);
    }
}
