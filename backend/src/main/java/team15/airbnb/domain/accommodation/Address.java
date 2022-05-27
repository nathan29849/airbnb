package team15.airbnb.domain.accommodation;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import team15.airbnb.domain.BaseEntity;

@Entity
public class Address extends BaseEntity {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 20)
	private String country;

	@NotNull
	@Column(length = 20)
	private String city;

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
