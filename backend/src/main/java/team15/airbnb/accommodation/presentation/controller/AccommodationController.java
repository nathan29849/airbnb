package team15.airbnb.accommodation.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team15.airbnb.accommodation.application.AccommodationService;
import team15.airbnb.accommodation.presentation.dto.AccommodationDetailsResponse;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeesResponse;
import team15.airbnb.accommodation.presentation.dto.SearchAccommodationsByOptionsResponse;
import team15.airbnb.accommodation.presentation.dto.SearchAccommodationsOptionsRequest;


@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    private final String minValue = "1000";
    private final String maxValue = "1000000";
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationDetailsResponse> searchAccommodation(
        @PathVariable(name = "id") Long accommodationId
    ) {
        return ResponseEntity.ok().body(accommodationService.searchById(accommodationId));
    }

    @GetMapping("/range")
    public ResponseEntity<AccommodationFeesResponse> searchAccommodationsByFeeRange(
            @RequestParam(defaultValue = minValue) int minPrice,
            @RequestParam(defaultValue = maxValue) int maxPrice) {
        return ResponseEntity.ok().body(accommodationService.searchByFeeRange(minPrice, maxPrice));
    }

    @GetMapping
    public ResponseEntity<SearchAccommodationsByOptionsResponse> searchAccommodationsWithOptions(SearchAccommodationsOptionsRequest request) {
        /*
        Todo : jwt 토큰으로부터 UserId 꺼내오는 작업 / 현재는 임시로 2번 유저를 기준으로 조회하도록 작성
         */
        return ResponseEntity.ok().body(accommodationService.searchByOptions(request, 2L));
    }
}
