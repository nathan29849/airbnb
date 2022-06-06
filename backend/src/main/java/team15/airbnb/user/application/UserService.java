package team15.airbnb.user.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.accommodation.infrastructure.AccommodationRepository;
import team15.airbnb.user.domain.Favorite;
import team15.airbnb.user.domain.User;
import team15.airbnb.user.infrastructure.UserRepository;
import team15.airbnb.user.presentation.dto.FavoriteDto;
import team15.airbnb.user.presentation.dto.FavoritesResponse;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final AccommodationRepository accommodationRepository;

	public UserService(UserRepository userRepository, AccommodationRepository accommodationRepository) {
		this.userRepository = userRepository;
		this.accommodationRepository = accommodationRepository;
	}

	@Transactional(readOnly = true)
	public FavoritesResponse searchFavorites(Long userId) {
		List<FavoriteDto> accommodations = userRepository.findFavorites(userId);
		return FavoritesResponse.convertFrom(accommodations);
	}

	@Transactional
	public void deleteFavorite(Long userId, Long accommodationId) {
		User savedUser = userRepository.findById(userId);
		Favorite favorite = savedUser.cancelFavorite(accommodationId);
		userRepository.delete(favorite);
	}
}
