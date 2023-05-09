package com.optum.customerglapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface TransactionConsumerChannel {

    String inChannel="in-channel";
    @Input(inChannel)
    MessageChannel consumerChannel();
}
