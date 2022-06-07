package team15.airbnb.search.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team15.airbnb.search.application.AutoCompleteService;
import team15.airbnb.search.presentation.dto.RecommendedKeywordListResponse;

@RequestMapping("/search")
@RestController
public class AutoCompleteController {

    private AutoCompleteService autoCompleteService;

    public AutoCompleteController(AutoCompleteService autoCompleteService) {
        this.autoCompleteService = autoCompleteService;
    }

    @GetMapping("")
    public ResponseEntity<RecommendedKeywordListResponse> autoComplete(@RequestParam String keyword) {
        return ResponseEntity.ok().body(autoCompleteService.searchRecommendedKeywords(keyword));
    }
}
