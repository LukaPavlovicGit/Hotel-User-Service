package com.raf.example.HotelUserService.messageHelper.messageListener;
import com.raf.example.HotelUserService.dto.ClientIdDto;
import com.raf.example.HotelUserService.dto.IncrementReservationDto;
import com.raf.example.HotelUserService.messageHelper.MessageHelper;
import com.raf.example.HotelUserService.service.UserService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class MessageListener {

    private MessageHelper messageHelper;
    private UserService userService;

    public MessageListener(MessageHelper messageHelper, UserService userService) {
        this.messageHelper = messageHelper;
        this.userService = userService;
    }

   @JmsListener(destination = "increment_reservation_queue", concurrency = "5-10")
    public void addOrder(Message message) throws JMSException {
        IncrementReservationDto incrementReservationDto = messageHelper.getMessage(message, IncrementReservationDto.class);
        userService.incrementNumberOfReservation(incrementReservationDto);
    }
}


