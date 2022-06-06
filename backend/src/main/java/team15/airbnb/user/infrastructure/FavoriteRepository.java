package team15.airbnb.user.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import team15.airbnb.user.domain.Favorite;

@Repository
public class FavoriteRepository {

	@PersistenceContext
	EntityManager em;
	public void delete(Favorite favorite) {
		em.remove(favorite);
	}

	public void addFavorite(Favorite favorite) {
		em.persist(favorite);
	}


}
