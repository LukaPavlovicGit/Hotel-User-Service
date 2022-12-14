package com.raf.example.HotelUserService.service;

import com.raf.example.HotelUserService.domain.ClientStatus;
import com.raf.example.HotelUserService.dto.ClientStatusDto;
import com.raf.example.HotelUserService.dto.DiscountDto;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
import com.raf.example.HotelUserService.repository.RankRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientStatusService {

    private ClientStatusRepository clientStatusRepository;
    private RankRepository rankRepository;
    private Mapper mapper;
    private JmsTemplate jmsTemplate;

    public ClientStatusService(ClientStatusRepository clientStatusRepository, RankRepository rankRepository, Mapper mapper, JmsTemplate jmsTemplate) {
        this.clientStatusRepository = clientStatusRepository;
        this.rankRepository = rankRepository;
        this.mapper = mapper;
        this.jmsTemplate = jmsTemplate;
    }

    public DiscountDto findDiscount(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository.findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));

        return new DiscountDto(clientStatus.getDiscount());
    }

    public ClientStatusDto findClientStatusByClientId(Long clientId) {
        return clientStatusRepository.findClientStatusByUserId(clientId)
                .map(mapper::clientStatusToClientStatusDto)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
    }

    public ClientStatusDto forbidAccess(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository.findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
        clientStatus.setAccessForbidden(true);
        clientStatusRepository.save(clientStatus);
        return mapper.clientStatusToClientStatusDto(clientStatus);
    }

    public ClientStatusDto allowAccess(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository
                .findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
        clientStatus.setAccessForbidden(false);
        clientStatusRepository.save(clientStatus);
        ClientStatusDto clientStatusDto = mapper.clientStatusToClientStatusDto(clientStatus);
        clientStatusDto.setRank(rankRepository.findByName(clientStatus.getRank().getName()).get());
        return clientStatusDto;
    }
}
