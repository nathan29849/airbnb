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
                                "a.id, (exists(select a.id from Favorite f where f.user.id = :userId and f.accommodation=a.id)) ,a.host.type, a.accommodationName, a.mainImage, (select avg(r.starRating) from Review r where r.accommodation.id = a.id), a.reviews.size, a.price, astext(a.address.coordinate) " +
                                ") " +
                                "from Accommodation a " +
                                "where a.price between :minPrice and :maxPrice " +
                                "and a.details.maximumGuestNumber >= :guestNumber " +
                                "and a.address.firstAddress like :address " +
                                "and not exists (select r.accommodation.id from Reservation r " +
                                "where r.accommodation.id = a.id " +
                                "and r.checkInDate >= :checkIn and r.checkInDate < :checkOut) " +
                                "group by a.id "
                        , AccommodationSimpleInfoResponse.class)
                .setParameter("userId", userId)
                .setParameter("minPrice", request.getMinPrice())
                .setParameter("maxPrice", request.getMaxPrice())
                .setParameter("guestNumber", request.getAdult() + request.getChild())
                .setParameter("address", "%" + request.getLocation() + "%")
                .setParameter("checkIn", request.getCheckIn())
                .setParameter("checkOut", request.getCheckOut())
                .setParameter("checkIn", request.getCheckIn())
                .setParameter("checkOut", request.getCheckOut())
                .setFirstResult((request.getPage()-1) * request.getLimit())
                .setMaxResults(request.getLimit() + 1)
                .getResultList();
    }

    public Long getAccommodationCounts() {
        return em.createQuery("select count(a) from Accommodation a", Long.class).getSingleResult();
    }
}
