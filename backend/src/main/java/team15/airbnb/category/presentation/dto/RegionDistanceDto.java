package team15.airbnb.category.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import team15.airbnb.accommodation.domain.City;

import java.math.BigInteger;

@NoArgsConstructor
@Getter
public class RegionDistanceDto {

    private BigInteger categoryId;
    private String categoryName;
    private String mainImage;
    private double distance;

    public RegionDistanceDto(BigInteger categoryId, String categoryName, String mainImage, double distance) {
        this.categoryId = categoryId;
        this.categoryName = City.valueOf(categoryName).getName();
        this.mainImage = mainImage;
        this.distance = distance;
    }
}
