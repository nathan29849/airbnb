package team15.airbnb.user.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.user.infrastructure.UserRepository;
import team15.airbnb.user.presentation.dto.FavoriteDto;
import team15.airbnb.user.presentation.dto.FavoritesResponse;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public FavoritesResponse searchFavorites(Long userId) {
		List<FavoriteDto> accommodations = userRepository.findFavorites(userId);
		return FavoritesResponse.convertFrom(accommodations);
	}
}
