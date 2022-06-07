package team15.airbnb.reservation.presentation.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import team15.airbnb.accommodation.domain.AccommodationImage;

@Getter
public class ReservationDetailsDto {

	private Long reservation;
	private LocalDate checkInTime;
	private LocalDate checkOutTime;
	private String hostName;
	private int guestCount;
	private int totalPrice;
	private List<String> images = new ArrayList<>();

	public ReservationDetailsDto(Long reservation, LocalDate checkInTime,
		LocalDate checkOutTime, String hostName, int guestCount, int totalPrice) {
		this.reservation = reservation;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.hostName = hostName;
		this.guestCount = guestCount;
		this.totalPrice = totalPrice;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
}
