package team15.airbnb.reservation.presentation.dto;

import java.time.LocalDate;
import lombok.Getter;
import team15.airbnb.accommodation.domain.City;

@Getter
public class ReservationDto {

	private Long reservationId;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private String location;
	private String accommodationName;
	private String mainImage;
	private boolean isDeleted;

	public ReservationDto(Long reservationId, LocalDate checkInDate, LocalDate checkOutDate,
		City city, String firstAddress, String accommodationName, String mainImage, boolean isDeleted) {
		this.reservationId = reservationId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.location = city.getName() + firstAddress;
		this.accommodationName = accommodationName;
		this.mainImage = mainImage;
		this.isDeleted = isDeleted;
	}
}
