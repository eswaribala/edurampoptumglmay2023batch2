package com.optum.transactionpublisher.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TransactionChannel.class)
public class StreamConfig {
}
