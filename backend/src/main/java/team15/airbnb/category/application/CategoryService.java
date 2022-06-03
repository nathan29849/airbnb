package team15.airbnb.category.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.category.infrastructure.RegionRepository;
import team15.airbnb.category.presentation.dto.RegionDistanceDto;
import team15.airbnb.category.presentation.dto.RegionResponse;

@Transactional
@Service
public class CategoryService {

    private final int CONVERSION_VALUE = 1000;
    private final int MINUTES = 60;
    private final int AVG_VELOCITY = 75;
    private final RegionRepository regionRepository;


    public CategoryService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<RegionResponse> searchRegions(double longitude, double latitude) {
        List<RegionDistanceDto> regions = regionRepository.findAllWithDistance(longitude, latitude);
        return regions.stream()
                .map(r -> RegionResponse.convertFrom(r, calcDurationTime(r.getDistance())))
                .collect(Collectors.toList());
    }

    private int calcDurationTime(double distance) {
        return (int) (distance % CONVERSION_VALUE % AVG_VELOCITY * MINUTES);
    }
}
