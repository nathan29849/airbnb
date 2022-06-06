package team15.airbnb.user.presentation.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import team15.airbnb.user.domain.UserType;

@Getter
public class FavoriteDto {

	private Long accommodationId;
	private boolean superhost;
	private String accommodationName;
	private String mainImage;
	private Double starRating;
	private Integer reviewCount;
	private int price;

	public FavoriteDto(Long accommodationId, UserType userType, String accommodationName,
		String mainImage, Double starRating, Integer reviewCount, int price) {
		this.accommodationId = accommodationId;
		this.superhost = userType.isSuperHost();
		this.accommodationName = accommodationName;
		this.mainImage = mainImage;
		this.starRating = starRating;
		this.reviewCount = reviewCount;
		this.price = price;
	}
}
