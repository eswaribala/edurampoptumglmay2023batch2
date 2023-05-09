package com.optum.transactionpublisher.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionChannel {

    String outChannel="out-channel";
    @Output(outChannel)
    MessageChannel publishChannel();
}
