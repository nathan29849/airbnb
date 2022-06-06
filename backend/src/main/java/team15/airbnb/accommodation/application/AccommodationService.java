package team15.airbnb.accommodation.application;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.infrastructure.AccommodationRepository;
import team15.airbnb.accommodation.presentation.dto.AccommodationDetailsResponse;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeeDto;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeesResponse;
import team15.airbnb.user.infrastructure.UserRepository;

@Slf4j
@Service
public class AccommodationService {

	private final AccommodationRepository accommodationRepository;
	private final UserRepository userRepository;

	public AccommodationService(AccommodationRepository accommodationRepository, UserRepository userRepository) {
		this.accommodationRepository = accommodationRepository;
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public AccommodationDetailsResponse searchById(Long accommodationId) {
		Accommodation accommodation = accommodationRepository.findById(accommodationId);
		/*
		TODO 유저 조회 (JWT 에 sign 된 user id를 통해서..) 후 like 여부 판단
		*/
		return AccommodationDetailsResponse.convertFrom(accommodation, true);
	}

	@Transactional(readOnly = true)
	public AccommodationFeesResponse searchByFeeRange(int minPrice, int maxPrice) {
		List<AccommodationFeeDto> accommodations = accommodationRepository.findByFee(minPrice, maxPrice);
		return AccommodationFeesResponse.convertFrom(accommodations);
	}
}
