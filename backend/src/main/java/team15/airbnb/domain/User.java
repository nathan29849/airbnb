package team15.airbnb.domain;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@Table(name = "users")
public class User extends BaseEntity{

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

	@OneToMany(mappedBy = "user")
	private List<Favorite> favorites = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations = new ArrayList<>();
}
