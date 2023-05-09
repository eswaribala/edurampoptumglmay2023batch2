package com.optum.customerglapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.customerglapi.dtos.TransactionVO;
import com.optum.customerglapi.facades.TransactionConsumerChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionConsumerService {

    private ObjectMapper objectMapper;
    public TransactionVO transactionVO;

    @StreamListener(target = TransactionConsumerChannel.inChannel)
    public void consumeTransaction(String message) {

        log.info("Transaction Received" + message);

        objectMapper = new ObjectMapper();
        try {
            transactionVO = objectMapper.readValue(message, TransactionVO.class);
            log.info("Java Object" + transactionVO);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
