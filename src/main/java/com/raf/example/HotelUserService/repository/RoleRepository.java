package com.raf.example.HotelUserService.repository;

import com.raf.example.HotelUserService.domain.Role;
import com.raf.example.HotelUserService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(String name);
}
