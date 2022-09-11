package com.raf.example.HotelUserService.repository;

import com.raf.example.HotelUserService.domain.Rank;
import com.raf.example.HotelUserService.rank.RankEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Optional<Rank> findByName(String enumName);
}
