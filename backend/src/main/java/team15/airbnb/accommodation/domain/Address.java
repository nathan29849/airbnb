package team15.airbnb.accommodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Embeddable
public class Address {

	public Address(Country country, City city, String firstAddress, String secondAddress, String zipcode, Point coordinate) {
		this.country = country;
		this.city = city;
		this.firstAddress = firstAddress;
		this.secondAddress = secondAddress;
		this.zipcode = zipcode;
		this.coordinate = coordinate;
	}

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
