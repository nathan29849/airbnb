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

    private static final String MIN_VALUE = "1000";
    private static final String MAX_VALUE = "1000000";
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationDetailsResponse> searchAccommodation(@PathVariable Long id) {
        return ResponseEntity.ok().body(accommodationService.searchById(id));
    }

    @GetMapping("/range")
    public ResponseEntity<AccommodationFeesResponse> searchAccommodationsByFeeRange(
            @RequestParam(defaultValue = MIN_VALUE) int minPrice,
            @RequestParam(defaultValue = MAX_VALUE) int maxPrice) {
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
