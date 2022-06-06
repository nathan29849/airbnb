package team15.airbnb.common.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Response <T> {

	private T data;

	public Response(T data) {
		this.data = data;
	}
}
