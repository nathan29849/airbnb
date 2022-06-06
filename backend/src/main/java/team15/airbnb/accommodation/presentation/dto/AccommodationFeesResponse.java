package team15.airbnb.accommodation.presentation.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class AccommodationFeesResponse {

	private List<AccommodationFeeDto> accommodations = new ArrayList<>();

	private AccommodationFeesResponse(
		List<AccommodationFeeDto> accommodations) {
		this.accommodations = accommodations;
	}

	public static AccommodationFeesResponse convertFrom(List<AccommodationFeeDto> accommodations) {
		return new AccommodationFeesResponse(accommodations);
	}
}
