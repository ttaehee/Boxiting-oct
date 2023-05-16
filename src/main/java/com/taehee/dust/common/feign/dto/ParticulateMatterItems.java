package com.taehee.dust.common.feign.dto;

public record ParticulateMatterItems(
        //TODO 추후 자료형 수정 고려
        Object stationName,
        Object mangName,
        Object sidoName,
        Object dataTime,
        Object so2Value,
        Object coValue,
        Object o3Value,
        Object no2Value,
        Object pm10Value,
        Object pm10Value24,
        Object pm25Value,
        Object pm25Value24,
        Object khaiValue,
        Object khaiGrade,
        Object so2Grade,
        Object coGrade,
        Object o3Grade,
        Object no2Grade,
        Object pm10Grade,
        Object pm25Grade,
        Object pm10Grade1h,
        Object pm25Grade1h
) {
}
