package team15.airbnb.category.infrastructure;

import org.springframework.stereotype.Repository;
import team15.airbnb.category.presentation.dto.EventResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EventRepository {

    @PersistenceContext
    private EntityManager em;

    public List<EventResponse> findAll() {
        return em.createQuery("select new team15.airbnb.category.presentation.dto.EventResponse(e.id, e.name, e.image) from Event e", EventResponse.class).getResultList();
    }
}
