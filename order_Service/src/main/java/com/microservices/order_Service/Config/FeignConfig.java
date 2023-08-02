package com.microservices.order_Service.Config;

import com.microservices.order_Service.external.decoder.CustomErrorDecoder;
import feign.Contract;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {


    @Bean
    ErrorDecoder errorDecoder(){
        return  new CustomErrorDecoder();

    }
}
