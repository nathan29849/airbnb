package team15.airbnb.category.infrastructure;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;
import team15.airbnb.category.domain.Region;
import team15.airbnb.category.presentation.dto.RegionDistanceDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        JpaResultMapper mapper = new JpaResultMapper();
        String point = String.format("'POINT(%s %s)'", latitude, longitude);

        Query q = em.createNativeQuery("select r.region_id as categoryId, r.region_name as categoryName, r.region_image as mainImage, " +
                "st_distance_sphere(ST_GeomFromText(" + point + "), r.coordinate) as distance from region r");

        return mapper.list(q, RegionDistanceDto.class);
    }
}
