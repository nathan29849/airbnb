package team15.airbnb.reservation.presentation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team15.airbnb.reservation.application.ReservationService;
import team15.airbnb.reservation.presentation.dto.PreviewResponse;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping("/preview")
	public ResponseEntity<PreviewResponse> previewFeePolicy(
		@RequestParam Long id,
		@RequestParam(name = "checkIn") String strCheckIn,
		@RequestParam(name = "checkOut") String strCheckOut
	){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate checkInDate = LocalDate.parse(strCheckIn, dateTimeFormatter);
		LocalDate checkOutDate = LocalDate.parse(strCheckOut, dateTimeFormatter);

		return ResponseEntity.ok().body(reservationService.previewReservationFee(id, checkInDate, checkOutDate));
	}
}
