package team15.airbnb.accommodation.domain;

import lombok.Getter;

@Getter
public enum DiscountPolicy {
	WEEKLY("주간할인", 0.04);

	private String name;
	private double rate;

	DiscountPolicy(String name, double rate) {
		this.name = name;
		this.rate = rate;
	}
}
