package com.taehee.dust.api;

import com.taehee.dust.api.dto.response.GetDustResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DustController {

    private final DustFacadeService dustFacadeService;

    @GetMapping("/{sidoName}/{stationName}")
    public ResponseEntity<GetDustResponse> getDustData(
            @PathVariable String sidoName,
            @PathVariable String stationName) {
        return ResponseEntity.ok(dustFacadeService.getDustData(sidoName, stationName));
    }
}
