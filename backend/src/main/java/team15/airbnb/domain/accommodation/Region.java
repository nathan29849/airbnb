package team15.airbnb.domain.accommodation;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {

	@Id
	@Column(name = "region_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "region_name")
	private String name;

	@Column(name = "region_image")
	private String image;

	@NotNull
	@Column(name = "region_latitude")
	private double latitude;

	@NotNull
	@Column(name = "region_longitude")
	private double longitude;
}
