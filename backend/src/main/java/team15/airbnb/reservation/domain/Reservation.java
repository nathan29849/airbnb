package team15.airbnb.reservation.domain;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.common.domain.BaseEntity;
import team15.airbnb.user.domain.User;

@Entity
public class Reservation extends BaseEntity {

	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDate checkInDate;

	@NotNull
	private LocalDate checkOutDate;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accommodation_id")
	private Accommodation accommodation;

	@NotNull
	private int guestCount;

	@NotNull
	private int totalPrice;
}
