package team15.airbnb.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddFavoriteRequest {

	private Long accommodationId;

	public AddFavoriteRequest(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
