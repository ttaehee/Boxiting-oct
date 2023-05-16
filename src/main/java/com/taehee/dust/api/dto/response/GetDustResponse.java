package com.taehee.dust.api.dto.response;

import com.taehee.dust.api.dto.Grade;
import com.taehee.dust.common.feign.dto.response.ParticulateMatterItems;

public record GetDustResponse(
        Object sido,
        Object stationName,
        Object pm10Value,
        Object pm25Value,
        String pm10Grade1h,
        String pm25Grade1h
) {
    public static GetDustResponse toGetDustResponse(ParticulateMatterItems particulateMatterItems) {
        int pm10Value = toInt(particulateMatterItems.pm10Value());
        int pm25Value = toInt(particulateMatterItems.pm25Value());

        return new GetDustResponse(
                particulateMatterItems.sidoName(),
                particulateMatterItems.stationName(),
                pm10Value,
                pm25Value,
                getPm10Grade(pm10Value),
                getPm25Grade(pm25Value)
        );
    }

    private static String getPm25Grade(int pm25Value) {
        if (0 <= pm25Value && pm25Value <= 15) {
            return Grade.GOOD.getName();
        }

        if (16 <= pm25Value && pm25Value <= 35) {
            return Grade.NORMAL.getName();
        }

        if (36 <= pm25Value && pm25Value <= 75) {
            return Grade.BAD.getName();
        }

        if (76 < pm25Value) {
            return Grade.VERY_BAD.getName();
        }

        return Grade.NOT_EXISTS.getName();
    }

    private static String getPm10Grade(int pm10Value) {
        if (0 <= pm10Value && pm10Value <= 30) {
            return Grade.GOOD.getName();
        }

        if (31 <= pm10Value && pm10Value <= 80) {
            return Grade.NORMAL.getName();
        }

        if (81 <= pm10Value && pm10Value <= 150) {
            return Grade.BAD.getName();
        }

        if (pm10Value > 150) {
            return Grade.VERY_BAD.getName();
        }

        return Grade.NOT_EXISTS.getName();
    }

    private static int toInt(Object value) {
        if (value.equals("-")) {
            return -1;
        }
        return Integer.parseInt(value.toString());
    }
}
