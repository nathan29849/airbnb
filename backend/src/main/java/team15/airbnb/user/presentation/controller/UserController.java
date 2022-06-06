package team15.airbnb.user.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team15.airbnb.user.application.UserService;
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
}
