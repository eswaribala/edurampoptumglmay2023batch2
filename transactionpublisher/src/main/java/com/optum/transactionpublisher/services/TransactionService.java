package com.optum.transactionpublisher.services;

import com.optum.transactionpublisher.dtos.TransactionVO;
import com.optum.transactionpublisher.facades.TransactionChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class TransactionService {
@Autowired
private TransactionChannel transactionChannel;
public boolean publishMessage(TransactionVO transactionVO){
    MessageChannel messageChannel=transactionChannel.publishChannel();
    return messageChannel.send(MessageBuilder
            .withPayload(transactionVO)
            .setHeader(MessageHeaders.CONTENT_TYPE,
                    MimeTypeUtils.APPLICATION_JSON)
            .build());

}

}
