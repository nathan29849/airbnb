package team15.airbnb.accommodation.presentation.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchAccommodationsOptionsRequest{

    private String location="";
    private String checkIn;
    private String checkOut;
    private int minPrice;
    private int maxPrice = 1000000;
    private int adult;
    private int child;
    private int baby;

}
