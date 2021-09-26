package com.epam.project.services;

import com.epam.project.data.CartData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private static final String QUEUE_NAME = "https://sqs.us-east-1.amazonaws.com/XXXXXXX/testQueue";

    @Autowired
    private MessageSender messageSender;

    public void checkout(CartData cart) throws JsonProcessingException {
        ObjectMapper mapper  = new ObjectMapper();
        String messagePayload = mapper.writeValueAsString(cart);

        messageSender.send(messagePayload);
    }
}
