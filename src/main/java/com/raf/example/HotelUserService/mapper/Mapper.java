package com.raf.example.HotelUserService.mapper;

import com.raf.example.HotelUserService.domain.*;
import com.raf.example.HotelUserService.dto.ClientStatusDto;
import com.raf.example.HotelUserService.dto.RankDto;
import com.raf.example.HotelUserService.dto.user.*;
import org.springframework.stereotype.Component;


@Component
public class Mapper {

    public UserDto userToUserDto(User user){
        return new UserDto(user.getUsername(),user.getFirstName(),user.getLastName(),user.getEmail(),
                user.getPhoneNumber(),user.getBirthdate(),user.getRole().getName(), user.getActivated());
    }
    public User userDtoToUser(UserDto userDto){
        return new User(userDto.getUsername(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                userDto.getPhoneNumber(), userDto.getBirthdate(), null, false);
    }
    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        return new Client(clientCreateDto.getUsername(),clientCreateDto.getPassword(),clientCreateDto.getFistName(),clientCreateDto.getLastName(),clientCreateDto.getEmail(),
                clientCreateDto.getPhoneNumber(), clientCreateDto.getBirthdate(),null, false, clientCreateDto.getNumOfPassport(), 0);
    }
    public Client clientDtoToClient(ClientDto clientDto){
        return new Client(clientDto.getUsername(),clientDto.getFirstName(),clientDto.getLastName(),clientDto.getEmail(),clientDto.getPhoneNumber(),clientDto.getBirthdate(),
                null, null, clientDto.getNumOfPassport(), clientDto.getNumOfReservation());
    }
    public ClientDto clientToClientDto(Client client){
       return new ClientDto(client.getUsername(),client.getFirstName(),client.getLastName(),client.getEmail(),client.getPhoneNumber(),
                            client.getBirthdate(),client.getNumOfPassport(), client.getNumOfReservation());
    }
    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDto){
        return new Manager(managerCreateDto.getUsername(),managerCreateDto.getPassword(),managerCreateDto.getFistName(),managerCreateDto.getLastName(),managerCreateDto.getEmail(),
                managerCreateDto.getPhoneNumber(), managerCreateDto.getBirthdate(), null, false, null,managerCreateDto.getHireDate());
    }
    public Manager managerDtoToManager(ManagerDto managerDto){
        return new Manager(managerDto.getUsername(),managerDto.getFistName(), managerDto.getLastName(), managerDto.getEmail(), managerDto.getPhoneNumber(), managerDto.getBirthdate(),
                            null, null, managerDto.getHotelName(), managerDto.getHireDate());
    }
    public ManagerDto managerToManagerDto(Manager manager){
        return new ManagerDto(manager.getUsername(), manager.getFirstName(), manager.getLastName(), manager.getEmail(), manager.getPhoneNumber(), manager.getBirthdate(),
                manager.getHotelName(), manager.getHireDate());
    }
    public ClientStatusDto clientStatusToClientStatusDto(ClientStatus clientStatus){
        return new ClientStatusDto(clientStatus.getUserId(), clientStatus.getAccessForbidden(),clientStatus.getDiscount(), null);
    }

    public Rank RankDtoToRank(RankDto rankDto){
        return new Rank(rankDto.getName(), rankDto.getReach());
    }

}
