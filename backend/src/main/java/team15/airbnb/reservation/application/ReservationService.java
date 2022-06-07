package team15.airbnb.reservation.application;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.infrastructure.AccommodationRepository;
import team15.airbnb.reservation.presentation.dto.PreviewResponse;

@Slf4j
@Service
public class ReservationService {

	private final AccommodationRepository accommodationRepository;

	public ReservationService(AccommodationRepository accommodationRepository) {
		this.accommodationRepository = accommodationRepository;
	}

	public PreviewResponse previewReservationFee(Long accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
		Accommodation accommodation = accommodationRepository.findById(accommodationId);
		int duration = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
		log.info("duration: {}", duration);
		return accommodation.previewReservationFee(duration);
	}
}
