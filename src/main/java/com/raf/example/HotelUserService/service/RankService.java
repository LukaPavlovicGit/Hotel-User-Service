package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.domain.Rank;
import com.raf.example.HotelUserService.dto.RankDto;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.exception.OperationNotAllowed;
import com.raf.example.HotelUserService.repository.RankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RankService {

    private RankRepository rankRepository;

    public RankService(RankRepository rankRepository){
        this.rankRepository = rankRepository;
    }

    public RankDto rankConfiguration(RankDto rankDto) {
        Rank rank = rankRepository
                .findByName(rankDto.getName())
                .orElseThrow(() -> new NotFoundException(String.format("Rank with a name: %s not found", rankDto.getName())));

        if(rank.getName().equals("BRONZE")){
            Rank silver = rankRepository
                    .findByName("SILVER")
                    .orElseThrow(() -> new NotFoundException("Rank with a name: SILVER not found"));

            if(rankDto.getReach() < silver.getReach()){
                rank.setReach(rankDto.getReach());
                rankRepository.save(rank);
            }
            else throw new OperationNotAllowed(String.format("Given reach for a BRONZE is %s, but should be smaller than reach of a SILVER which is %s", rankDto.getReach(), silver.getReach()));
        }

        else if(rank.getName().equals("SILVER")){
            Rank bronze = rankRepository
                    .findByName("BRONZE")
                    .orElseThrow(() -> new NotFoundException("Rank with a name: SILVER not found"));
            Rank gold = rankRepository
                    .findByName("GOLD")
                    .orElseThrow(() -> new NotFoundException("Rank with a name: SILVER not found"));

            if(rankDto.getReach() > bronze.getReach()){
                 if(rankDto.getReach() < gold.getReach()){
                    rank.setReach(rankDto.getReach());
                     rankRepository.save(rank);
                 }
                 else throw new OperationNotAllowed(String.format("Given reach for a SILVER is %s, but should be smaller than reach of a GOLD which is %s", rankDto.getReach(), gold.getReach()));
            }
            else throw new OperationNotAllowed(String.format("Given reach for a SILVER is %s, but should be bigger than reach of a BRONZE which is %s", rankDto.getReach(), bronze.getReach()));
        }
        else if(rank.getName().equals("GOLD")){
            Rank silver = rankRepository
                    .findByName("SILVER")
                    .orElseThrow(() -> new NotFoundException("Rank with a name: SILVER not found"));

            if(rankDto.getReach() > silver.getReach()){
                silver.setReach(rankDto.getReach());
                rankRepository.save(rank);
            }
            else throw new OperationNotAllowed(String.format("Given reach for a GOLD is %s, but should be bigger than reach of a SILVER which is %s", rankDto.getReach(), silver.getReach()));
        }

        return rankDto;
    }
}
