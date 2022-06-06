package team15.airbnb.category.infrastructure;

import org.springframework.stereotype.Repository;
import team15.airbnb.category.domain.Region;
import team15.airbnb.category.presentation.dto.RegionDistanceDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RegionRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Region region) {
        em.persist(region);
    }

    public Region findById(Long id) {
        return em.find(Region.class, id);
    }

    public List<Region> findAll() {
        return em.createQuery("select r from Region r", Region.class).getResultList();
    }

    public List<RegionDistanceDto> findAllWithDistance(double latitude, double longitude) {
        String point = String.format("'POINT(%s %s)'", latitude, longitude);

        return em.createQuery("select new team15.airbnb.category.presentation.dto.RegionDistanceDto(r.id, r.city, r.image, function('st_distance_sphere', ST_GeomFromText(" + point +"), r.coordinate)) from Region r", RegionDistanceDto.class)
                .getResultList();
    }
}
