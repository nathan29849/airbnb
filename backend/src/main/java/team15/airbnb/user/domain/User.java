package team15.airbnb.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import team15.airbnb.common.domain.BaseEntity;
import team15.airbnb.accommodation.domain.Review;
import team15.airbnb.reservation.domain.Reservation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

	public User(String name, UserType type, String profileImage) {
		this.name = name;
		this.type = type;
		this.profileImage = profileImage;
	}

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "user_name", length = 20)
	private String name;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "user_type")
	private UserType type;

	private String profileImage;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Favorite> favorites = new ArrayList<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Reservation> reservations = new ArrayList<>();
}
