package team15.airbnb.category.presentation.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegionResponse {

    private Long categoryId;
    private String categoryName;
    private String mainImage;
    private int durationTime;

    private RegionResponse(Long categoryId, String categoryName, String mainImage, int durationTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.mainImage = mainImage;
        this.durationTime = durationTime;
    }

    public static RegionResponse convertFrom(RegionDistanceDto dto, int durationTime) {
        return new RegionResponse(dto.getCategoryId(), dto.getCategoryName(), dto.getMainImage(), durationTime);
    }

}
