package com.taehee.dust.common.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@ImportAutoConfiguration({
        OpenFeignConfig.class,
        OpenApiProperties.class,
        FeignAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class
})
public class OpenFeignTestContext {
}
