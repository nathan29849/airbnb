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
