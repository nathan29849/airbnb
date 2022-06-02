package team15.airbnb.category.application;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.category.presentation.dto.RegionResponse;

@Transactional
@Service
public class CategoryService {

	public List<RegionResponse> searchRegions(double latitude, double longitude) {
		return null;
	}
}
