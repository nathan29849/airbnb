package team15.airbnb.accommodation.presentation.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team15.airbnb.accommodation.domain.Accommodation;
import team15.airbnb.accommodation.domain.AccommodationDetails;
import team15.airbnb.user.domain.User;

@Getter
@Builder
@NoArgsConstructor
public class AccommodationDetailsResponse {

	private Long accommodationId;
	private boolean like;
	private String hostName;
	private String hostImage;
	private String accommodationName;
	private String location;
	private double starRating;
	private AccommodationDetails accommodationDetails;
	private List<String> images;

	private AccommodationDetailsResponse(Long accommodationId, boolean like, String hostName,
		String hostImage, String accommodationName, String location, double starRating,
		AccommodationDetails accommodationDetails, List<String> images) {
		this.accommodationId = accommodationId;
		this.like = like;
		this.hostName = hostName;
		this.hostImage = hostImage;
		this.accommodationName = accommodationName;
		this.location = location;
		this.starRating = starRating;
		this.accommodationDetails = accommodationDetails;
		this.images = images;
	}

	public static AccommodationDetailsResponse convertFrom(Accommodation accommodation, boolean like) {
		User host = accommodation.getHost();
		return AccommodationDetailsResponse.builder()
				.accommodationId(accommodation.getId())
				.like(like)
				.hostName(host.getName())
				.hostImage(host.getProfileImage())
				.accommodationName(accommodation.getAccommodationName())
				.location(accommodation.getAddress().getFirstAddress())
				.starRating(accommodation.getStarRating())
				.accommodationDetails(accommodation.getDetails())
				.images(accommodation.getImageUrls())
				.build();
	}
}
