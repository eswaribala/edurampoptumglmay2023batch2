package com.optum.customerglapi.configurations;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeDataConfig {

@Bean
public Faker getFaker(){
    return new Faker();
}

}
