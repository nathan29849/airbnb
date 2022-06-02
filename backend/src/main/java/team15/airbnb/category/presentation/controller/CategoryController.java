package team15.airbnb.category.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team15.airbnb.category.application.CategoryService;
import team15.airbnb.category.presentation.dto.RegionListResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;

	@GetMapping("/region")
	public ResponseEntity<RegionListResponse> searchRegionList(
		@RequestParam double latitude,
		@RequestParam double longitude
	) {
		return ResponseEntity.ok().body(new RegionListResponse(categoryService.searchRegions(latitude, longitude)));
	}

}
