package team15.airbnb.user.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.infrastructure.AccommodationRepository;
import team15.airbnb.user.domain.Favorite;
import team15.airbnb.user.domain.User;
import team15.airbnb.user.infrastructure.FavoriteRepository;
import team15.airbnb.user.infrastructure.UserRepository;
import team15.airbnb.user.presentation.dto.FavoriteDto;
import team15.airbnb.user.presentation.dto.FavoritesResponse;

@Service
public class FavoriteService {

	private final UserRepository userRepository;
	private final AccommodationRepository accommodationRepository;
	private final FavoriteRepository favoriteRepository;

	public FavoriteService(UserRepository userRepository,
		AccommodationRepository accommodationRepository,
		FavoriteRepository favoriteRepository) {
		this.userRepository = userRepository;
		this.accommodationRepository = accommodationRepository;
		this.favoriteRepository = favoriteRepository;
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
		favoriteRepository.delete(favorite);
	}

	@Transactional
	public void addFavorite(Long userId, Long accommodationId) {
		User savedUser = userRepository.findById(userId);
		Accommodation accommodation = accommodationRepository.findById(accommodationId);
		favoriteRepository.addFavorite(new Favorite(savedUser, accommodation));
	}
}
