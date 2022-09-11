package com.raf.example.HotelUserService.runner;
import com.raf.example.HotelUserService.domain.*;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
import com.raf.example.HotelUserService.repository.RankRepository;
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
    private RankRepository rankRepository;

    public TestDataRunner(RoleRepository roleRepository, UserRepository userRepository, ClientStatusRepository clientStatusRepository, RankRepository rankRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.clientStatusRepository = clientStatusRepository;
        this.rankRepository = rankRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        clientStatusRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();
        rankRepository.deleteAll();

        Rank bronze = new Rank("BRONZE", 3);
        Rank silver = new Rank("SILVER", 6);
        Rank gold = new Rank("GOLD", 10);
        rankRepository.save(bronze);
        rankRepository.save(silver);
        rankRepository.save(gold);

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
        admin.setFirstName("Luka");
        admin.setLastName("Pavlovic");
        admin.setPhoneNumber("0641234567");
        admin.setBirthdate(new Date());
        admin.setRole(roleAdmin);

        Client c1 = new Client();
        c1.setEmail("c1@gmail.com");
        c1.setUsername("c1");
        c1.setPassword("c1");
        c1.setFirstName("Luka");
        c1.setLastName("Pavlovic2323");
        c1.setPhoneNumber("0641234567");
        c1.setBirthdate(new Date());
        c1.setRole(roleClient);
        c1.setNumOfPassport("123553431");

        Client c2 = new Client();
        c2.setEmail("c2@gmail.com");
        c2.setUsername("c2");
        c2.setPassword("c2");
        c2.setFirstName("Luka");
        c2.setLastName("Pavlovicwwww");
        c2.setPhoneNumber("0641234567");
        c2.setBirthdate(new Date());
        c2.setRole(roleClient);
        c2.setNumOfPassport("33255123");

        Manager m1 = new Manager();
        m1.setEmail("m1@gmail.com");
        m1.setUsername("m1");
        m1.setPassword("m1");
        m1.setFirstName("aaaaa");
        m1.setLastName("1111111");
        m1.setPhoneNumber("0641234567");
        m1.setBirthdate(new Date());
        m1.setRole(roleManager);
        m1.setHireDate(new Date());
        m1.setHotelName("hotel2");

        Manager m2 = new Manager();
        m2.setEmail("m2@gmail.com");
        m2.setUsername("m2");
        m2.setPassword("m2");
        m2.setFirstName("bbbbbb");
        m2.setLastName("222222222");
        m2.setPhoneNumber("0641234567");
        m2.setBirthdate(new Date());
        m2.setRole(roleManager);
        m2.setHireDate(new Date());
        m2.setHotelName("hotel1");

        userRepository.save(admin);
        userRepository.save(c1);
        userRepository.save(c2);
        userRepository.save(m1);
        userRepository.save(m2);

        ClientStatus k1Status = new ClientStatus(c1.getId(), bronze);
        ClientStatus k2Status = new ClientStatus(c2.getId(), bronze);

        clientStatusRepository.save(k1Status);
        clientStatusRepository.save(k2Status);



    }
}
