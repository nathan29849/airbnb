package team15.airbnb.user.presentation.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class FavoritesResponse {

	private List<FavoriteDto> accommodations = new ArrayList<>();

	public FavoritesResponse(List<FavoriteDto> accommodations) {
		this.accommodations = accommodations;
	}

	public static FavoritesResponse convertFrom(List<FavoriteDto> accommodations) {
		return new FavoritesResponse(accommodations);
	}
}
