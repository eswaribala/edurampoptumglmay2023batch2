package com.optum.customerglapi.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.optum.customerglapi.dtos.TransactionVO;
import com.optum.customerglapi.services.TransactionConsumerService;
import net.datafaker.Faker;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
@Component
public class TransactionSubscriptionResolver implements GraphQLSubscriptionResolver {
    @Autowired
    private Faker faker;
    @Autowired
    private TransactionConsumerService transactionConsumerService;
    public Publisher<TransactionVO> subscribeTransactions(long accountNo) {

        Random random = new Random();
       /* return Flux.interval(Duration.ofSeconds(5))
                .map(num -> new TransactionVO(random.nextInt(10000000),random.nextInt(10000000),
                        LocalDate.of(2000+random.nextInt(20), random.nextInt(10),random.nextInt(26))
                        ,accountNo) );

        return Flux.interval(Duration.ofSeconds(5))
                .map(num ->TransactionVO.builder().transactionId(faker.random().nextInt(1000000))
                        .transactionDate(LocalDate.of(2000+faker.random().nextInt(20),
                                1+faker.random().nextInt(10),1+faker.random().nextInt(25)))
                        .amount(faker.random().nextInt(1000000)).accountNo(accountNo).build());


        */

        return Flux.interval(Duration.ofSeconds(5))
                .map(num ->transactionConsumerService.transactionVO);

    }
}
