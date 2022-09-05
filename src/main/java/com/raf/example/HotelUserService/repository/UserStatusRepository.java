package com.raf.example.HotelUserService.repository;

import com.raf.example.HotelUserService.domain.Role;
import com.raf.example.HotelUserService.domain.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {
}
