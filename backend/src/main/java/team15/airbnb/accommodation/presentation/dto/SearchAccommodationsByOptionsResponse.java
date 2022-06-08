package team15.airbnb.accommodation.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchAccommodationsByOptionsResponse {

    /*
    Todo: 페이징 처리를 완료하면 hasNext값을 설정할 것.
     */
    private boolean hasNext;
    private AccommodationListResponse data;

    public SearchAccommodationsByOptionsResponse(boolean hasNext, AccommodationListResponse data) {
        this.hasNext = hasNext;
        this.data = data;
    }
}
