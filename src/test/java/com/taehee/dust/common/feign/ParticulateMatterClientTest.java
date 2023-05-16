package com.taehee.dust.common.feign;

import com.taehee.dust.common.config.OpenApiProperties;
import com.taehee.dust.common.config.OpenFeignConfig;
import com.taehee.dust.common.config.OpenFeignTest;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@OpenFeignTest
@ImportAutoConfiguration(OpenFeignConfig.class)
public class ParticulateMatterClientTest {

    private final Logger log = LoggerFactory.getLogger(ParticulateMatterClientTest.class);

    @Autowired
    private ParticulateMatterClient particulateMatterClient;

    @Autowired
    private OpenApiProperties openApiProperties;

    @Test
    @DisplayName("open api를 호출하여 미세먼지 정보를 가져올 수 있다.")
    void call() {
        //given
        String serviceKey = openApiProperties.getServiceKey();
        String returnType = openApiProperties.getReturnType();
        String numOfRows = openApiProperties.getNumOfRows();
        String pageNo = openApiProperties.getPageNo();
        String sidoName = "서울";
        String ver = openApiProperties.getVer();

        //when
        ParticulateMatterResponse result = particulateMatterClient.call(
                serviceKey, returnType, numOfRows, pageNo, sidoName, ver
        );

        //then
        assertThat(result.response().body().items())
                .isNotNull();
        log.info("result: {}", result);
    }
}