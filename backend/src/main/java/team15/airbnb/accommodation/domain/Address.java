package team15.airbnb.accommodation.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

	@NotNull
	@Enumerated(value = EnumType.STRING)
	@Column(length = 20)
	private Country country;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	@Column(length = 20)
	private City city;

	@NotNull
	@Column(length = 50)
	private String firstAddress;

	@NotNull
	@Column(length = 50)
	private String secondAddress;

	@NotNull
	@Column(length = 10)
	private String zipcode;

	@NotNull
	@Column(columnDefinition = "point")
	private Point coordinate;
}
