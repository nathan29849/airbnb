package team15.airbnb.reservation.application;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.domain.AccommodationImage;
import team15.airbnb.accommodation.infrastructure.AccommodationRepository;
import team15.airbnb.reservation.domain.Reservation;
import team15.airbnb.reservation.infrastructure.ReservationRepository;
import team15.airbnb.reservation.presentation.dto.PreviewResponse;
import team15.airbnb.reservation.presentation.dto.ReservationDetailsDto;
import team15.airbnb.reservation.presentation.dto.ReservationDetailsResponse;
import team15.airbnb.reservation.presentation.dto.ReservationResponse;
import team15.airbnb.reservation.presentation.dto.ReserveDto;
import team15.airbnb.user.domain.User;
import team15.airbnb.user.infrastructure.UserRepository;

@Slf4j
@Service
public class ReservationService {

	private final AccommodationRepository accommodationRepository;
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;

	public ReservationService(
		AccommodationRepository accommodationRepository,
		ReservationRepository reservationRepository,
		UserRepository userRepository) {
		this.accommodationRepository = accommodationRepository;
		this.reservationRepository = reservationRepository;
		this.userRepository = userRepository;
	}

	public PreviewResponse previewReservationFee(Long accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
		Accommodation accommodation = accommodationRepository.findById(accommodationId);
		int duration = calculateDuration(checkInDate, checkOutDate);
		log.info("duration: {}", duration);
		return accommodation.previewReservationFee(duration);
	}

	@Transactional(readOnly = true)
	public ReservationResponse searchReservation(Long userId) {
		return new ReservationResponse(reservationRepository.findByUserId(userId));
	}

	@Transactional(readOnly = true)
	public ReservationDetailsResponse searchDetails(Long reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId);
		List<AccommodationImage> images = reservation.getAccommodation().getImages();
		return new ReservationDetailsResponse(new ReservationDetailsDto(reservation, images));
	}

	@Transactional
	public void reserve(Long accommodationId, Long userId, ReserveDto reserveDto) {
		User user = userRepository.findById(userId);
		Accommodation accommodation = accommodationRepository.findById(accommodationId);
		int duration = calculateDuration(reserveDto.getCheckInDate(), reserveDto.getCheckOutDate());
		/*
		* 1. 예약하고자 하는 기간에 해당 숙소가 예약이 가능한지 여부 체크
		* 2. 예약을 하다가 저장은 됐는데, 중간에 네트워크 이슈로 인하여, 클라이언트 측에 OK를 전달하지 못하였을 때
		* 	- userId, accommodationId, checkInDate, checkOutDate 를 통해서 이미 DB에 저장이 되어있는 숙소인지 체크
		* */
		if (!validateReservation(accommodationId, reserveDto)) {
			throw new IllegalStateException("해당 날짜는 다른 유저에게 예약이 되어 있습니다.");
		}

		boolean sameReservation = reservationRepository.isSameReservation(accommodationId, userId, reserveDto);
		if (sameReservation) { return; }

		reservationRepository.save(
			new Reservation(
				reserveDto.getCheckInDate(),
				reserveDto.getCheckOutDate(),
				user,
				accommodation,
				reserveDto.getGuestCount(),
				accommodation.calculateTotalPrice(duration)
				));
	}

	private boolean validateReservation(Long accommodationId, ReserveDto reserveDto) {
		return reservationRepository.validate(accommodationId, reserveDto);
	}

	private int calculateDuration(LocalDate reserveDto, LocalDate reserveDto1) {
		return (int) ChronoUnit.DAYS.between(reserveDto, reserveDto1);
	}


	@Transactional
	public void cancel(Long reservationId, Long userId) {
		User user = userRepository.findById(userId);
		reservationRepository.cancel(reservationId, user);
	}
}
