package team15.airbnb.domain.accommodation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import team15.airbnb.domain.BaseEntity;

@Entity
public class Address extends BaseEntity {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	private double latitude;

	@NotNull
	private double longtitude;
}
