package com.taehee.dust.common.feign.dto.response;

import java.util.List;

public record ParticulateMatterResponse(
        Response response
) {
    public record Response(
            Body body
    ) {
    }

    public record Body(
            Integer totalCount,
            List<ParticulateMatterItems> items
    ) {
    }
}
