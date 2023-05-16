package com.taehee.dust.common.feign;

import com.taehee.dust.common.config.OpenFeignConfig;
import com.taehee.dust.common.feign.dto.request.ParticulateMatterRequest;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ParticulateMatterClient", url = "${api.url}", configuration = OpenFeignConfig.class)
public interface ParticulateMatterClient {

    @GetMapping
    ParticulateMatterResponse call(@RequestBody ParticulateMatterRequest particulateMatterRequest);
}
