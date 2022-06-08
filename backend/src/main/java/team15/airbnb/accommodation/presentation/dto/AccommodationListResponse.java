package team15.airbnb.accommodation.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class AccommodationListResponse {

    private long totalCount;
    private List<AccommodationSimpleInfoResponse> accommodations = new ArrayList<>();

    public AccommodationListResponse(long totalCount, List<AccommodationSimpleInfoResponse> accommodations) {
        this.totalCount = totalCount;
        this.accommodations = accommodations;
    }
}
