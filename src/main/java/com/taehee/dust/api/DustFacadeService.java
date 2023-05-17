package com.taehee.dust.api;

import com.taehee.dust.api.dto.response.GetAllMeasuringStationResponse;
import com.taehee.dust.api.dto.response.GetDustResponse;
import com.taehee.dust.common.config.OpenApiProperties;
import com.taehee.dust.common.feign.ParticulateMatterClient;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterItems;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterResponse;
import com.taehee.dust.domain.location.model.Location;
import com.taehee.dust.domain.location.repository.LocationRepository;
import com.taehee.dust.domain.measuringstation.model.MeasuringStation;
import com.taehee.dust.domain.measuringstation.repository.MeasuringStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.taehee.dust.api.dto.response.GetAllMeasuringStationResponse.toGetAllMeasuringStationResponse;
import static com.taehee.dust.api.dto.response.GetDustResponse.toGetDustResponse;

@Service
@RequiredArgsConstructor
public class DustFacadeService {

    private final OpenApiProperties openApiProperties;
    private final ParticulateMatterClient particulateMatterClient;

    private final LocationRepository locationRepository;
    private final MeasuringStationRepository measuringStationRepository;

    public GetDustResponse getDustData(String locationName, String measuringStationName) {
        ParticulateMatterItems particulateMatterItems = getParticulateMatterDataFromOpenApi(locationName).stream()
                .filter(item -> item.stationName().equals(measuringStationName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return toGetDustResponse(particulateMatterItems);
    }

    public GetAllMeasuringStationResponse getAllMeasuringStation(String locationName) {
        Location location = locationRepository.findByName(locationName)
                .orElseThrow(IllegalArgumentException::new);
        List<MeasuringStation> measuringStations = measuringStationRepository.findAllByLocationOrderByNameAsc(location);

        return toGetAllMeasuringStationResponse(measuringStations);
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
