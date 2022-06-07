package team15.airbnb.search.presentation.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RecommendedKeywordListResponse {

    private List<String> keywords = new ArrayList<>();

    public RecommendedKeywordListResponse(List<String> keywords) {
        this.keywords = keywords;
    }
}
