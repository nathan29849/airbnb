package team15.airbnb.domain.accommodation;

import javax.validation.constraints.NotNull;
import javax.persistence.Embeddable;

@Embeddable
public class AccommodationDetails {

	@NotNull
	private int maximumGuestNumber;

	@NotNull
	private int roomCount;

	@NotNull
	private int bedCount;

	@NotNull
	private int bathroomCount;
}
