package team15.airbnb.reservation.presentation.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ReservationResponse {

	private List<ReservationDto> reservations = new ArrayList<>();

	public ReservationResponse(List<ReservationDto> reservations) {
		this.reservations = reservations;
	}
}
