package com.raf.example.HotelUserService.repository;

import com.raf.example.HotelUserService.domain.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<ClientStatus, Long> {
}
