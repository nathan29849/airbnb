package team15.airbnb.category.infrastructure;

import org.springframework.stereotype.Repository;
import team15.airbnb.category.domain.Region;

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

}
