package team15.airbnb.reservation.infrastructure;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import team15.airbnb.reservation.domain.Reservation;
import team15.airbnb.reservation.presentation.dto.ReservationDto;

@Repository
public class ReservationRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Reservation reservation) {
		em.persist(reservation);
	}

	public Reservation findById(Long reservationId) {
		return em.find(Reservation.class, reservationId);
	}

	public List<ReservationDto> findByUserId(Long userId) {
		return em.createQuery(
				"select new team15.airbnb.reservation.presentation.dto.ReservationDto("
					+ "r.id, r.checkInDate, r.checkOutDate, a.address.city, a.address.firstAddress, "
					+ "a.accommodationName, a.mainImage, r.isDeleted) "
					+ "from Reservation r "
					+ "join r.accommodation a "
					+ "where r.user.id = :userId", ReservationDto.class)
			.setParameter("userId", userId)
			.getResultList();
	}
}
