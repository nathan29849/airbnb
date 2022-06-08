package team15.airbnb.accommodation.presentation.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchAccommodationsOptionsRequest {

    private String location = "";
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;
    private int minPrice;
    private int maxPrice = 1000000;
    private int adult;
    private int child;
    private int baby;
    private int page = 1;
    private int limit = 5;
}
