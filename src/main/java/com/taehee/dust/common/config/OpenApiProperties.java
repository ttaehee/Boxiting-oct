package com.taehee.dust.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenApiProperties {
    @Value("${api.apiKey}")
    private String apiKey;

    @Value("${api.returnType}")
    private String returnType;

    @Value("${api.numOfRows}")
    private String numOfRows;

    @Value("${api.pageNo}")
    private String pageNo;

    @Value("${api.sidoName}")
    private String sidoName;

    @Value("${api.ver}")
    private String ver;
}
