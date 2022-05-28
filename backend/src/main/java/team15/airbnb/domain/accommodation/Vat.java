package team15.airbnb.domain.accommodation;

import javax.validation.constraints.NotNull;
import javax.persistence.Embeddable;

@Embeddable
public class Vat {

	@NotNull
	private double cleaningFee;

	@NotNull
	private double serviceFee;

	@NotNull
	private double accommodationTax;
}
