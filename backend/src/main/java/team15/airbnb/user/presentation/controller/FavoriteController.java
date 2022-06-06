package team15.airbnb.user.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team15.airbnb.user.presentation.dto.AddFavoriteDto;
import team15.airbnb.user.application.FavoriteService;
import team15.airbnb.user.presentation.dto.DeleteFavoriteDto;
import team15.airbnb.user.presentation.dto.FavoritesResponse;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

	private final FavoriteService favoriteService;

	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}

	@GetMapping
	public ResponseEntity<FavoritesResponse> searchFavorites() {
		/*
		* TODO: JWT를 통해 User id를 조회 (우선 default는 user_id=2)
		*/
		return ResponseEntity.ok().body(favoriteService.searchFavorites(2L));
	}

	@PostMapping("/add")
	public ResponseEntity<Void> addFavorite(@RequestBody AddFavoriteDto addFavoriteDto) {
		/*
		 * TODO: JWT를 통해 User id를 조회(우선 default는 user_id=2)
		 */
		favoriteService.addFavorite(2L, addFavoriteDto.getAccommodationId());
		return ResponseEntity.ok().build();
	}

	@PostMapping("/remove")
	public ResponseEntity<Void> deleteFavorite(@RequestBody DeleteFavoriteDto deleteFavoriteDto)
		throws JsonProcessingException {
		/*
		* TODO: JWT를 통해 User id를 조회(우선 default는 user_id=2)
		 */
		favoriteService.deleteFavorite(2L, deleteFavoriteDto.getAccommodationId());
		return ResponseEntity.ok().build();
	}
}
