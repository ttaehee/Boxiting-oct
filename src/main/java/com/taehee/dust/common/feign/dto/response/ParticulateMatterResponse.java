package com.taehee.dust.common.feign.dto.response;

import com.taehee.dust.common.feign.dto.ParticulateMatterItems;

import java.util.List;

public record ParticulateMatterResponse(
        Integer totalCount,
        List<ParticulateMatterItems> items
) {
}
