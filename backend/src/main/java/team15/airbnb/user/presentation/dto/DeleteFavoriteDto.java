package team15.airbnb.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteFavoriteDto {

	private Long accommodationId;

	public DeleteFavoriteDto(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
