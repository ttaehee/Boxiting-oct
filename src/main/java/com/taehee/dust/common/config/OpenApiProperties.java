package com.taehee.dust.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class OpenApiProperties {
    @Value("${api.serviceKey}")
    private String serviceKey;

    @Value("${api.returnType}")
    private String returnType;

    @Value("${api.numOfRows}")
    private String numOfRows;

    @Value("${api.pageNo}")
    private String pageNo;

    @Value("${api.ver}")
    private String ver;
}
