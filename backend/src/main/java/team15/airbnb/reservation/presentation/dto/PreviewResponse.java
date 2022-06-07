package team15.airbnb.reservation.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PreviewResponse {

	private int price;
	private int discount;
	private int cleaningFee;
	private int serviceFee;
	private int accommodationTax;
	private int totalPrice;

	public PreviewResponse(int price, int discount, int cleaningFee, int serviceFee, int accommodationTax, int totalPrice) {
		this.price = price;
		this.discount = discount;
		this.cleaningFee = cleaningFee;
		this.serviceFee = serviceFee;
		this.accommodationTax = accommodationTax;
		this.totalPrice = totalPrice;
	}
}
