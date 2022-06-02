package team15.airbnb.accommodation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Embeddable
public class AccommodationDetails {

	public AccommodationDetails(int maximumGuestNumber, int roomCount, int bedCount, int bathroomCount) {
		this.maximumGuestNumber = maximumGuestNumber;
		this.roomCount = roomCount;
		this.bedCount = bedCount;
		this.bathroomCount = bathroomCount;
	}

	@NotNull
	private int maximumGuestNumber;

	@NotNull
	private int roomCount;

	@NotNull
	private int bedCount;

	@NotNull
	private int bathroomCount;
}
