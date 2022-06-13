package team15.airbnb.domain.accommodation;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import team15.airbnb.domain.BaseEntity;

@Entity
public class AccommodationImage extends BaseEntity {

	@Id
	@Column(name = "accommodation_image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String url;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accommodation_id")
	private Accommodation accommodation;
}
