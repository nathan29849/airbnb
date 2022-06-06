package team15.airbnb.category.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team15.airbnb.category.infrastructure.EventRepository;
import team15.airbnb.category.infrastructure.RegionRepository;
import team15.airbnb.category.presentation.dto.EventListResponse;
import team15.airbnb.category.presentation.dto.RegionDistanceDto;
import team15.airbnb.category.presentation.dto.RegionResponse;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final int CONVERSION_VALUE = 1000;
    private final int MINUTES = 60;
    private final int AVG_VELOCITY = 75;
    private final RegionRepository regionRepository;
    private final EventRepository eventRepository;

    public CategoryService(RegionRepository regionRepository, EventRepository eventRepository) {
        this.regionRepository = regionRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional(readOnly = true)
    public List<RegionResponse> searchRegions(double longitude, double latitude) {
        List<RegionDistanceDto> regions = regionRepository.findAllWithDistance(longitude, latitude);
        return regions.stream()
                .map(r -> RegionResponse.convertFrom(r, calcDurationTime(r.getDistance())))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EventListResponse searchEvents() {
        return new EventListResponse(eventRepository.findAll());

    }

    private int calcDurationTime(double distance) {
        return (int) (distance % CONVERSION_VALUE % AVG_VELOCITY * MINUTES);
    }
}
