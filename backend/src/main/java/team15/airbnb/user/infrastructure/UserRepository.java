package team15.airbnb.user.infrastructure;

import org.springframework.stereotype.Repository;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeeDto;
import team15.airbnb.user.domain.Favorite;
import team15.airbnb.user.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import team15.airbnb.user.presentation.dto.FavoriteDto;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public List<FavoriteDto> findFavorites(Long userId) {
        return em.createQuery(
                "select new team15.airbnb.user.presentation.dto.FavoriteDto("
                    + "a.id, a.host.type, a.accommodationName, a.mainImage, "
                    + "(select avg((r.starRating)) from Review r where r.accommodation.id = a.id), "
                    + "a.reviews.size, a.price) "
                    + "from Accommodation a "
                    + "join Favorite f on a.id = f.accommodation.id where f.user.id = :userId group by a.id",
//                "join f.accommodation a where f.user.id = :userId group by a.id"
                FavoriteDto.class)
            .setParameter("userId", userId)
            .getResultList();
    }


}
