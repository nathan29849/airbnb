package team15.airbnb.domain.accommodation;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import team15.airbnb.domain.BaseEntity;

@Entity
public class DiscountPolicy extends BaseEntity {

	@Id
	@Column(name = "policy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 20)
	private String title;

	@NotNull
	private double discountRate;
}
