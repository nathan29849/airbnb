package team15.airbnb.accommodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Embeddable
public class Vat {

	public Vat(double cleaningFee, double serviceFee, double accommodationTax) {
		this.cleaningFee = cleaningFee;
		this.serviceFee = serviceFee;
		this.accommodationTax = accommodationTax;
	}

	@NotNull
	private double cleaningFee;

	@NotNull
	private double serviceFee;

	@NotNull
	private double accommodationTax;
}
