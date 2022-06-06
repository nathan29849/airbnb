package team15.airbnb.accommodation.infrastructure;

import java.util.List;
import org.springframework.stereotype.Repository;
import team15.airbnb.accommodation.domain.Accommodation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeeDto;
import team15.airbnb.accommodation.presentation.dto.AccommodationFeesResponse;
import team15.airbnb.category.presentation.dto.RegionDistanceDto;

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
}
