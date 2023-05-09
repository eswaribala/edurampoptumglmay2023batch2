package com.optum.customerglapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TransactionConsumerChannel.class)
public class StreamConfig {
}
