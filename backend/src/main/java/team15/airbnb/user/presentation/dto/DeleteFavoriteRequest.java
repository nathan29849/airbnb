package team15.airbnb.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteFavoriteRequest {

	private Long accommodationId;

	public DeleteFavoriteRequest(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
