package team15.airbnb.accommodation.presentation.dto;

import lombok.Getter;

@Getter
public class AccommodationFeeDto {

	private Long id;
	private int price;

	public AccommodationFeeDto(Long id, int price) {
		this.id = id;
		this.price = price;
	}
}
