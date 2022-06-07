package team15.airbnb.reservation.presentation.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import team15.airbnb.accommodation.domain.AccommodationImage;
import team15.airbnb.reservation.domain.Reservation;

@Getter
public class ReservationDetailsDto {

	private Long reservationId;
	private LocalDate checkInTime;
	private LocalDate checkOutTime;
	private String hostName;
	private int guestCount;
	private int totalPrice;
	private List<String> images = new ArrayList<>();

	public ReservationDetailsDto(Reservation reservation, List<AccommodationImage> images) {
		this.reservationId = reservation.getId();
		this.checkInTime = reservation.getCheckInDate();
		this.checkOutTime = reservation.getCheckOutDate();
		this.hostName = reservation.getAccommodation().getHost().getName();
		this.guestCount = reservation.getGuestCount();
		this.totalPrice = reservation.getTotalPrice();
		this.images = convertImagesUrl(images);
	}

	public List<String> convertImagesUrl(List<AccommodationImage> images) {
		return images.stream()
			.map(AccommodationImage::getUrl)
			.collect(Collectors.toList());
	}
}
