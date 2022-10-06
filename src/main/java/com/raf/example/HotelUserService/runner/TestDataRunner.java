package com.raf.example.HotelUserService.runner;
import com.raf.example.HotelUserService.domain.*;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
import com.raf.example.HotelUserService.repository.RankRepository;
import com.raf.example.HotelUserService.repository.RoleRepository;
import com.raf.example.HotelUserService.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Date;

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

        userRepository.deleteAll();
        roleRepository.deleteAll();
        rankRepository.deleteAll();
        clientStatusRepository.deleteAll();

        //Insert roles
        Role roleClient = new Role("ROLE_CLIENT");
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleManager = new Role("ROLE_MANAGER");
        roleRepository.save(roleClient);
        roleRepository.save(roleAdmin);
        roleRepository.save(roleManager);

        //Insert admin
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setFirstName("Luka");
        admin.setLastName("Pavlovic");
        admin.setPhoneNumber("0641234567");
        admin.setBirthdate(Date.valueOf("1990-10-10"));
        admin.setRole(roleAdmin);
        admin.setActivated(true);

        userRepository.save(admin);

        //insert ranks
        Rank bronze = new Rank("BRONZE", 3);
        Rank silver = new Rank("SILVER", 6);
        Rank gold = new Rank("GOLD", -1);
        rankRepository.save(bronze);
        rankRepository.save(silver);
        rankRepository.save(gold);

        /*clientStatusRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();
        rankRepository.deleteAll();

        Rank bronze = new Rank("BRONZE", 3);
        Rank silver = new Rank("SILVER", 6);
        Rank gold = new Rank("GOLD", -1);
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
        admin.setActivated(true);

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
        c1.setActivated(true);

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
        c2.setActivated(true);

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
        m1.setActivated(true);

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
        m2.setActivated(true);

        Manager m3 = new Manager();
        m3.setEmail("m3@gmail.com");
        m3.setUsername("m3");
        m3.setPassword("m3");
        m3.setFirstName("bbbbbb");
        m3.setLastName("222222222");
        m3.setPhoneNumber("0641234567");
        m3.setBirthdate(new Date());
        m3.setRole(roleManager);
        m3.setHireDate(new Date());
        m3.setActivated(true);

        Manager m4 = new Manager();
        m4.setEmail("m4@gmail.com");
        m4.setUsername("m4");
        m4.setPassword("m4");
        m4.setFirstName("bbbbbb");
        m4.setLastName("222222222");
        m4.setPhoneNumber("0641234567");
        m4.setBirthdate(new Date());
        m4.setRole(roleManager);
        m4.setHireDate(new Date());
        m4.setActivated(true);

        Manager m5 = new Manager();
        m5.setEmail("m5@gmail.com");
        m5.setUsername("m5");
        m5.setPassword("m5");
        m5.setFirstName("bbbbbb");
        m5.setLastName("222222222");
        m5.setPhoneNumber("0641234567");
        m5.setBirthdate(new Date());
        m5.setRole(roleManager);
        m5.setHireDate(new Date());
        m5.setActivated(true);

        Manager m6= new Manager();
        m6.setEmail("m6@gmail.com");
        m6.setUsername("m6");
        m6.setPassword("m6");
        m6.setFirstName("bbbbbb");
        m6.setLastName("222222222");
        m6.setPhoneNumber("0641234567");
        m6.setBirthdate(new Date());
        m6.setRole(roleManager);
        m6.setHireDate(new Date());
        m6.setActivated(true);

        Manager m7 = new Manager();
        m7.setEmail("m7@gmail.com");
        m7.setUsername("m7");
        m7.setPassword("m7");
        m7.setFirstName("bbbbbb");
        m7.setLastName("222222222");
        m7.setPhoneNumber("0641234567");
        m7.setBirthdate(new Date());
        m7.setRole(roleManager);
        m7.setHireDate(new Date());
        m7.setActivated(true);

        userRepository.save(admin);
        userRepository.save(c1);
        userRepository.save(c2);
        userRepository.save(m1);
        userRepository.save(m2);
        userRepository.save(m3);
        userRepository.save(m4);
        userRepository.save(m5);
        userRepository.save(m6);
        userRepository.save(m7);



        ClientStatus k1Status = new ClientStatus(c1.getId(), bronze);
        ClientStatus k2Status = new ClientStatus(c2.getId(), bronze);

        clientStatusRepository.save(k1Status);
        clientStatusRepository.save(k2Status);
*/


    }
}
