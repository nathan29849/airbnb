package team15.airbnb.reservation.domain;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime checkInDate;

	@NotNull
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime checkOutDate;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accommodation_id")
	private Accommodation accommodation;
}
