package team15.airbnb.accommodation.infrastructure;

import org.springframework.stereotype.Repository;
import team15.airbnb.accommodation.domain.Accommodation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccommodationRepository {

    @PersistenceContext
    private EntityManager em;


    public void save(Accommodation accommodation) {
        em.persist(accommodation);
    }

    public Accommodation findById(Long id) {
        return em.find(Accommodation.class, id);
    }

}
