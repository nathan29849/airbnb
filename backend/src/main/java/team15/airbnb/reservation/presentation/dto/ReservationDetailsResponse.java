package team15.airbnb.reservation.presentation.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ReservationDetailsResponse {

	private ReservationDetailsDto reservationDetails;

	public ReservationDetailsResponse(ReservationDetailsDto reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
}
