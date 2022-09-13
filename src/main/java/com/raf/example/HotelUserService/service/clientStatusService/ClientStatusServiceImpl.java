package com.raf.example.HotelUserService.service.clientStatusService;

import com.raf.example.HotelUserService.domain.ClientStatus;
import com.raf.example.HotelUserService.dto.ClientStatusDto;
import com.raf.example.HotelUserService.dto.DiscountDto;
import com.raf.example.HotelUserService.exception.NotFoundException;
import com.raf.example.HotelUserService.mapper.Mapper;
import com.raf.example.HotelUserService.repository.ClientStatusRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientStatusServiceImpl implements ClientStatusService {

    private ClientStatusRepository clientStatusRepository;
    private Mapper mapper;
    private JmsTemplate jmsTemplate;

    public ClientStatusServiceImpl(ClientStatusRepository clientStatusRepository, Mapper mapper, JmsTemplate jmsTemplate) {
        this.clientStatusRepository = clientStatusRepository;
        this.mapper = mapper;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public DiscountDto findDiscount(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository.findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));

        return new DiscountDto(clientStatus.getDiscount());
    }

    @Override
    public ClientStatusDto findClientStatusByClientId(Long clientId) {
        return clientStatusRepository.findClientStatusByUserId(clientId)
                .map(mapper::clientStatusToClientStatusDto)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
    }

    @Override
    public ClientStatusDto forbidAccess(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository.findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
        clientStatus.setAccessForbidden(true);
        clientStatusRepository.save(clientStatus);
        return mapper.clientStatusToClientStatusDto(clientStatus);
    }

    @Override
    public ClientStatusDto allowAccess(Long clientId) {
        ClientStatus clientStatus = clientStatusRepository
                .findClientStatusByUserId(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d does not exists.", clientId)));
        clientStatus.setAccessForbidden(false);
        clientStatusRepository.save(clientStatus);
        return mapper.clientStatusToClientStatusDto(clientStatus);
    }
}
