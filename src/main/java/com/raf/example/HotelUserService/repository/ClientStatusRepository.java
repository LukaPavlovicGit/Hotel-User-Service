package com.raf.example.HotelUserService.repository;

import com.raf.example.HotelUserService.domain.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {
    Optional<ClientStatus> findClientStatusByUserId(Long clientId);
}
