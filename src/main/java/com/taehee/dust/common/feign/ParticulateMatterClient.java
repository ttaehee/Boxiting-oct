package com.taehee.dust.common.feign;

import com.taehee.dust.common.config.OpenFeignConfig;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ParticulateMatterClient", url = "${api.url}", configuration = OpenFeignConfig.class)
public interface ParticulateMatterClient {

    @GetMapping
    ParticulateMatterResponse call(@RequestParam(value = "serviceKey") String serviceKey,
                                   @RequestParam(value = "returnType") String returnType,
                                   @RequestParam(value = "numOfRows") String numOfRows,
                                   @RequestParam(value = "pageNo") String pageNo,
                                   @RequestParam(value = "sidoName") String sidoName,
                                   @RequestParam(value = "ver") String ver);
}
