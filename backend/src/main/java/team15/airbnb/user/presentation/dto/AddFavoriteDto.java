package team15.airbnb.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddFavoriteDto {

	private Long accommodationId;

	public AddFavoriteDto(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
