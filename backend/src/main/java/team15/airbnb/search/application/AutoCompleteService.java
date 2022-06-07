package team15.airbnb.search.application;

import org.springframework.stereotype.Service;
import team15.airbnb.search.infrastructure.AutoCompleteRepository;
import team15.airbnb.search.presentation.dto.RecommendedKeywordListResponse;

@Service
public class AutoCompleteService {

    private AutoCompleteRepository autoCompleteRepository;

    public AutoCompleteService(AutoCompleteRepository autoCompleteRepository) {
        this.autoCompleteRepository = autoCompleteRepository;
    }

    public RecommendedKeywordListResponse searchRecommendedKeywords(String keyword) {
        return new RecommendedKeywordListResponse(autoCompleteRepository.findByKeyword(keyword));
    }
}
