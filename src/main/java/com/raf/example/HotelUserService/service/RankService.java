package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.domain.Rank;
import com.raf.example.HotelUserService.dto.RankDto;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.exception.OperationNotAllowed;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.repository.RankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RankService {

    private RankRepository rankRepository;
    private Mapper mapper;

    public RankService(RankRepository rankRepository, Mapper mapper) {
        this.rankRepository = rankRepository;
        this.mapper = mapper;
    }

    public RankDto save(RankDto rankDto){
        Optional<Rank> rank = rankRepository.findByName(rankDto.getName());
        if(rank.isPresent())
            throw new OperationNotAllowed(String.format("Rank with a name: %s already exist", rankDto.getName()));

        rankRepository.save(mapper.RankDtoToRank(rankDto));
        return rankDto;
    }
    public List<RankDto> saveAll(List<RankDto> ranksDto){
        System.out.println(ranksDto);
        for(RankDto r : ranksDto){
            Optional<Rank> rank = rankRepository.findByName(r.getName());
            if(rank.isPresent())
                throw new OperationNotAllowed(String.format("Rank with a name: %s already exist", r.getName()));
        }
        for(RankDto r : ranksDto)
            rankRepository.save(mapper.RankDtoToRank(r));

        return ranksDto;
    }
    public RankDto rankConfiguration(RankDto rankDto) {
        Rank rank = rankRepository
                .findById(rankDto.getId())
                .orElseThrow(() -> new NotFoundException(String.format("Rank with a name: %s not found", rankDto.getName())));
        rank.setReach(rankDto.getReach());
        rank.setName(rankDto.getName());
        rankRepository.save(rank);
        return rankDto;
    }
}
