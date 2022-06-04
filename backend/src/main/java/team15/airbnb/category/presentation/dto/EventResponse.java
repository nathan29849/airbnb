package team15.airbnb.category.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import team15.airbnb.category.domain.Event;

@Getter
@NoArgsConstructor
public class EventResponse {

    private Long categoryId;
    private String categoryName;
    private String mainImage;

    public EventResponse(Long categoryId, String categoryName, String mainImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.mainImage = mainImage;
    }

    public static EventResponse convertFrom(Event event) {
        return new EventResponse(event.getId(), event.getName(), event.getImage());
    }
}
