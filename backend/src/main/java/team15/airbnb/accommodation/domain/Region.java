package team15.airbnb.accommodation.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Getter
@NoArgsConstructor
@Entity
public class Region {

	public Region(City name, String image, Point coordinate) {
		this.name = name;
		this.image = image;
		this.coordinate = coordinate;
	}

	@Id
	@Column(name = "region_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	@Column(name = "region_name")
	private City name;

	@Column(name = "region_image")
	private String image;

	@NotNull
	@Column(columnDefinition = "point")
	private Point coordinate;
}
