package team15.airbnb.accommodation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Vat {

	@NotNull
	private double cleaningFee;

	@NotNull
	private double serviceFee;

	@NotNull
	private double accommodationTax;
}
