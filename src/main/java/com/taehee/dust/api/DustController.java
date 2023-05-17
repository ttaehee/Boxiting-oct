package com.taehee.dust.api;

import com.taehee.dust.api.dto.response.GetAllMeasuringStationResponse;
import com.taehee.dust.api.dto.response.GetDustResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DustController {

    private final DustFacadeService dustFacadeService;

    @GetMapping("/{locationName}/{measuringStationName}")
    public ResponseEntity<GetDustResponse> getDustData(
            @PathVariable String locationName,
            @PathVariable String measuringStationName) {
        return ResponseEntity.ok(dustFacadeService.getDustData(locationName, measuringStationName));
    }

    @GetMapping("/{locationName}")
    public ResponseEntity<GetAllMeasuringStationResponse> getAllMeasuringStation(
            @PathVariable String locationName) {
        return ResponseEntity.ok(dustFacadeService.getAllMeasuringStation(locationName));
    }

    @PostMapping("/{locationName}")
    public ResponseEntity<Void> saveMeasuringStation(
            @PathVariable String locationName) {
        dustFacadeService.saveMeasuringStation(locationName);
        return ResponseEntity.ok().build();
    }
}
