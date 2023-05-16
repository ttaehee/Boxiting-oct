package com.taehee.dust.common.feign.dto.request;

public record ParticulateMatterRequest(
        String serviceKey,
        String returnType,
        String numOfRows,
        String pageNo,
        String sidoName,
        String ver
) {
}
