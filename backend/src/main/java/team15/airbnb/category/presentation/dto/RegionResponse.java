package team15.airbnb.category.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RegionResponse {

	private Long categoryId;
	private String categoryName;
	private String imageUrl;
	private int distance;

	public RegionResponse(Long categoryId, String categoryName, String imageUrl, int distance) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
		this.distance = distance;
	}

}
