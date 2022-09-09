package com.raf.example.HotelUserService.mapper;

import com.raf.example.HotelUserService.domain.Client;
import com.raf.example.HotelUserService.domain.ClientStatus;
import com.raf.example.HotelUserService.domain.Manager;
import com.raf.example.HotelUserService.domain.User;
import com.raf.example.HotelUserService.dto.clientStatus.ClientStatusDto;
import com.raf.example.HotelUserService.dto.user.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
public class Mapper {
    private ModelMapper modelMapper;

    public Mapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        Client client = new Client();
        client = modelMapper.map(clientCreateDto, Client.class);
        return client;
    }

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }

    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDto){
        Manager manager = new Manager();
        manager = modelMapper.map(managerCreateDto, Manager.class);
        return manager;
    }

    public ManagerDto managerToManagerDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto = modelMapper.map(manager, ManagerDto.class);
        return managerDto;
    }

    public ClientStatusDto clientStatusToClientStatusDto(ClientStatus clientStatus){
        ClientStatusDto clientStatusDto = new ClientStatusDto();
        clientStatusDto = modelMapper.map(clientStatus, ClientStatusDto.class);
        return clientStatusDto;
    }

}
