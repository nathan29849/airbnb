package team15.airbnb.accommodation.infrastructure;

import org.springframework.stereotype.Repository;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeeDto;
import team15.airbnb.accommodation.presentation.dto.AccommodationSimpleInfoResponse;
import team15.airbnb.accommodation.presentation.dto.SearchAccommodationsOptionsRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<AccommodationFeeDto> findByFee(int minPrice, int maxPrice) {
        return em.createQuery(
                        "select new team15.airbnb.accommodation.presentation.dto.AccommodationFeeDto(a.id, a.price) "
                                + "from Accommodation a WHERE (:minPrice <= a.price and a.price <= :maxPrice) ORDER BY a.price",
                        AccommodationFeeDto.class)
                .setParameter("minPrice", minPrice)
                .setParameter("maxPrice", maxPrice)
                .getResultList();
    }

    public List<AccommodationSimpleInfoResponse> findByOptions(SearchAccommodationsOptionsRequest request, Long userId) {

        return em.createQuery(
                        "select new team15.airbnb.accommodation.presentation.dto.AccommodationSimpleInfoResponse(" +
                                "a.id, (count(f)>0),a.host.type, a.accommodationName, a.mainImage, "
                                + "avg(r.starRating), a.reviews.size, a.price, astext(a.address.coordinate) " +
                                ") " +
                                "from Accommodation a " +
                                "left join Favorite f on f.accommodation = a.id " +
                                "left join Review r on r.accommodation.id = a.id " +
                                "left join Reservation re on re.accommodation.id = a.id " +
                                "where f.user.id = :userId " +
                                "and a.price between :minPrice and :maxPrice " +
                                "and a.details.maximumGuestNumber >= :guestNumber " +
                                "and a.address.firstAddress like :address " +
                                "and (re.checkInDate >= :checkOut or re.checkOutDate < :checkIn) or re.accommodation = null " +
                                "group by a.id"
                        , AccommodationSimpleInfoResponse.class)
                .setParameter("userId", userId)
                .setParameter("minPrice", request.getMinPrice())
                .setParameter("maxPrice", request.getMaxPrice())
                .setParameter("guestNumber", request.getAdult() + request.getChild())
                .setParameter("address", "%" + request.getLocation() + "%")
                .setParameter("checkOut", request.getCheckOut())
                .setParameter("checkIn", request.getCheckIn())
                .setFirstResult((request.getPage() - 1) * request.getLimit())
                .setMaxResults(request.getLimit() + 1)
                .getResultList();
    }

    public int getAccommodationCounts(SearchAccommodationsOptionsRequest request) {
        List<Long> list = em.createQuery(
                        "select count(a) " +
                                "from Accommodation a " +
                                "left join Reservation re on re.accommodation.id = a.id " +
                                "where a.price between :minPrice and :maxPrice " +
                                "and a.details.maximumGuestNumber >= :guestNumber " +
                                "and a.address.firstAddress like :address " +
                                "and (re.checkInDate >= :checkOut or re.checkOutDate < :checkIn) or re.accommodation = null " +
                                "group by a.id"
                        , Long.class)
                .setParameter("minPrice", request.getMinPrice())
                .setParameter("maxPrice", request.getMaxPrice())
                .setParameter("guestNumber", request.getAdult() + request.getChild())
                .setParameter("address", "%" + request.getLocation() + "%")
                .setParameter("checkOut", request.getCheckOut())
                .setParameter("checkIn", request.getCheckIn())
                .getResultList();

        return list.size();
    }
}
