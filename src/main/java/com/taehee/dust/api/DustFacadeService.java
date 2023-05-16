package com.taehee.dust.api;

import com.taehee.dust.api.dto.response.GetDustResponse;
import com.taehee.dust.common.config.OpenApiProperties;
import com.taehee.dust.common.feign.ParticulateMatterClient;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterItems;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.taehee.dust.api.dto.response.GetDustResponse.toGetDustResponse;

@Service
@RequiredArgsConstructor
public class DustFacadeService {

    private final OpenApiProperties openApiProperties;
    private final ParticulateMatterClient particulateMatterClient;

    public GetDustResponse getDustData(String sidoName, String measuringStationName) {
        ParticulateMatterItems particulateMatterItems = getParticulateMatterDataFromOpenApi(sidoName).stream()
                .filter(item -> item.stationName().equals(measuringStationName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return toGetDustResponse(particulateMatterItems);
    }

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
