package team15.airbnb.search.infrastructure;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AutoCompleteRepository {

    @PersistenceContext
    private EntityManager em;

    public List<String> findByKeyword(String keyword) {
        return em.createQuery("select distinct a.address.firstAddress " +
                        "from Accommodation a " +
                        "where a.address.firstAddress like :keyword")
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

}
