package team15.airbnb.category.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class EventListResponse {

    public EventListResponse(List<EventResponse> events) {
        this.events = events;
    }

    private List<EventResponse> events = new ArrayList<>();
}
