package team15.airbnb.reservation.presentation.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@NoArgsConstructor
public class ReserveDto {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkInDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOutDate;
	private int guestCount;
}
