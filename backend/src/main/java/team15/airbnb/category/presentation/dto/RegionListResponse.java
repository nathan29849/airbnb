package team15.airbnb.category.presentation.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RegionListResponse {

	private List<RegionResponse> regions;

	public RegionListResponse(List<RegionResponse> regions) {
		this.regions = regions;
	}
}
