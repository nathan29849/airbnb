package team15.airbnb.accommodation.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.infrastructure.AccommodationRepository;
import team15.airbnb.accommodation.presentation.dto.AccommodationDetailsResponse;
import team15.airbnb.user.infrastructure.UserRepository;

@Slf4j
@Transactional
@Service
public class AccommodationService {

	private final AccommodationRepository accommodationRepository;
	private final UserRepository userRepository;

	public AccommodationService(AccommodationRepository accommodationRepository, UserRepository userRepository) {
		this.accommodationRepository = accommodationRepository;
		this.userRepository = userRepository;
	}

	public AccommodationDetailsResponse searchById(Long accommodationId) {
		Accommodation accommodation = accommodationRepository.findById(accommodationId);
		/*
		TODO 유저 조회 (JWT 에 sign 된 user id를 통해서..) 후 like 여부 판단
		*/
		return AccommodationDetailsResponse.convertFrom(accommodation, true);
	}


}
