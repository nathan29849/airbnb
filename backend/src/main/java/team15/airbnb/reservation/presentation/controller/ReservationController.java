package team15.airbnb.reservation.presentation.controller;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team15.airbnb.reservation.application.ReservationService;
import team15.airbnb.reservation.presentation.dto.PreviewResponse;
import team15.airbnb.reservation.presentation.dto.ReservationDetailsResponse;
import team15.airbnb.reservation.presentation.dto.ReservationResponse;
import team15.airbnb.reservation.presentation.dto.ReserveDto;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping
	public ResponseEntity<ReservationResponse> searchReservation() {
		/*
		TODO : user 정보 체크 후 user id 가져오기 (현재는 default : 4)
		*/
		return ResponseEntity.ok().body(reservationService.searchReservation(4L));
	}

	@GetMapping("/preview")
	public ResponseEntity<PreviewResponse> previewFeePolicy(
		@RequestParam(name = "accommodationId") Long accommodationId,
		@RequestParam(name = "checkIn") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkInDate,
		@RequestParam(name = "checkOut") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOutDate
	){
		return ResponseEntity.ok().body(reservationService.previewReservationFee(accommodationId, checkInDate, checkOutDate));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReservationDetailsResponse> searchDetails(
		@PathVariable(name = "id") Long reservationId
	) {
		return ResponseEntity.ok().body(reservationService.searchDetails(reservationId));
	}

	@PostMapping("/{id}")
	public ResponseEntity<Void> reserve(
		@PathVariable(name = "id") Long accommodationId,
		@RequestBody ReserveDto reserveDto
	) {
		/*
		TODO : user 조회 후 user id 가져와야 함 (default : 4L)
		*/
		reservationService.reserve(accommodationId, 4L, reserveDto);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}/cancel")
	public ResponseEntity<Void> cancel(
		@PathVariable(name = "id") Long reservationId
	) {
		/*
		TODO : user 조회 후 user id 가져와야 함 (default : 2L)
		*/
		reservationService.cancel(reservationId, 2L);
		return ResponseEntity.ok().build();

	}
}
