package com.taehee.dust.api.dto.response;

import com.taehee.dust.domain.measuringstation.model.MeasuringStation;

import java.util.List;
import java.util.stream.Collectors;

public record GetAllMeasuringStationResponse(
        List<String> measuringStationNames
) {
    public static GetAllMeasuringStationResponse toGetAllMeasuringStationResponse(List<MeasuringStation> measuringStations) {
        return new GetAllMeasuringStationResponse(
                measuringStations.stream()
                .map(MeasuringStation::getName)
                .collect(Collectors.toList())
        );
    }
}
