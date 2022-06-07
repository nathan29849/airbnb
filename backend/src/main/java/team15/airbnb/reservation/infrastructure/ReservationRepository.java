package team15.airbnb.reservation.infrastructure;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import team15.airbnb.accommodation.domain.AccommodationImage;
import team15.airbnb.reservation.presentation.dto.ReservationDetailsDto;
import team15.airbnb.reservation.presentation.dto.ReservationDto;

@Repository
public class ReservationRepository {

	@PersistenceContext
	private EntityManager em;

	public List<ReservationDto> findByUserId(Long userId) {
		return em.createQuery(
				"select new team15.airbnb.reservation.presentation.dto.ReservationDto("
					+ "r.id, r.checkInDate, r.checkOutDate, a.address.city, a.address.firstAddress, a.accommodationName, a.mainImage) "
					+ "from Reservation r "
					+ "join r.accommodation a "
					+ "where r.user.id = :userId and r.isDeleted = false ", ReservationDto.class)
			.setParameter("userId", userId)
			.getResultList();
	}

	public ReservationDetailsDto findByAccommodationId(Long accommodationId) {
		return em.createQuery(
			"select new team15.airbnb.reservation.presentation.dto.ReservationDetailsDto("
				+ "r.id, r.checkInDate, r.checkOutDate, a.host.name, r.guestCount, r.totalPrice)"
				+ "from Reservation r "
				+ "join r.accommodation a where a.id = :accommodationId", ReservationDetailsDto.class)
			.setParameter("accommodationId", accommodationId)
			.getSingleResult();
	}

	public List<String> findImages(Long accommodationId) {
		return em.createQuery(
				"select i.url from AccommodationImage i where i.accommodation.id = :accommodationId ", String.class
			).setParameter("accommodationId", accommodationId)
			.getResultList();
	}
}
