package com.taehee.dust.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.taehee.dust.common.feign")
public class OpenFeignConfig {

}