package com.taehee.dust.api;

import com.taehee.dust.common.config.OpenApiProperties;
import com.taehee.dust.common.feign.ParticulateMatterClient;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterItems;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DustFacadeService {

    private final OpenApiProperties openApiProperties;
    private final ParticulateMatterClient particulateMatterClient;

    private List<ParticulateMatterItems> getParticulateMatterDataFromOpenApi(String sidoName) {
        ParticulateMatterResponse particulateMatterResponse = particulateMatterClient.call(
                openApiProperties.getServiceKey(),
                openApiProperties.getReturnType(),
                openApiProperties.getNumOfRows(),
                openApiProperties.getPageNo(),
                sidoName,
                openApiProperties.getVer()
        );
        return particulateMatterResponse.response().body().items();
    }
}
