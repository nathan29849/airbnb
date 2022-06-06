package team15.airbnb.user.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team15.airbnb.user.application.UserService;
import team15.airbnb.user.presentation.dto.DeleteFavoriteDto;
import team15.airbnb.user.presentation.dto.FavoritesResponse;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/favorites")
	public ResponseEntity<FavoritesResponse> searchFavorites() {
		/*
		* TODO: JWT를 통해 User id를 조회 (우선 default는 user_id=2)
		*/
		return ResponseEntity.ok().body(userService.searchFavorites(2L));
	}

	@PostMapping("/favorites/remove")
	public ResponseEntity<Void> deleteFavorite(@RequestBody DeleteFavoriteDto deleteFavoriteDto)
		throws JsonProcessingException {
		/*
		* TODO: JWT를 통해 User id를 조회(우선 default는 user_id=2)
		 */
		userService.deleteFavorite(2L, deleteFavoriteDto.getAccommodationId());
		return ResponseEntity.ok().build();
	}
}
