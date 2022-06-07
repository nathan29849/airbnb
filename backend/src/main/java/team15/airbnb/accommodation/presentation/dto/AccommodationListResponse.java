package team15.airbnb.accommodation.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class AccommodationListResponse {

    private int totalCount;
    private List<AccommodationSimpleInfoResponse> accommodations = new ArrayList<>();

    public AccommodationListResponse(List<AccommodationSimpleInfoResponse> accommodations) {
        totalCount = accommodations.size();
        this.accommodations = accommodations;
    }
}
