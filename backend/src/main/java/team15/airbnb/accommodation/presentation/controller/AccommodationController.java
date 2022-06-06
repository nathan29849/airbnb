package team15.airbnb.accommodation.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team15.airbnb.accommodation.application.AccommodationService;
import team15.airbnb.accommodation.presentation.dto.AccommodationDetailsResponse;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeesResponse;

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
}
