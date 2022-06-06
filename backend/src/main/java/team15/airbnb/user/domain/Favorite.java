package team15.airbnb.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team15.airbnb.accommodation.domain.Accommodation;

@Getter
@Entity
@NoArgsConstructor
public class Favorite {

	@Id
	@Column(name = "favorite_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accommodation_id")
	private Accommodation accommodation;

	public Favorite(User user, Accommodation accommodation) {
		this.user = user;
		this.accommodation = accommodation;
	}
}
