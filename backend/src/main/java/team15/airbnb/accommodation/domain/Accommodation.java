package team15.airbnb.accommodation.domain;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import team15.airbnb.category.domain.Region;
import team15.airbnb.common.domain.BaseEntity;
import team15.airbnb.category.domain.Event;
import team15.airbnb.reservation.domain.Reservation;
import team15.airbnb.reservation.presentation.dto.PreviewResponse;
import team15.airbnb.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
public class Accommodation extends BaseEntity {

	public Accommodation(String accommodationName, String description, AccommodationType type, int price, String mainImage, Vat vat, Address address, AccommodationDetails details, int checkInTime, int checkOutTime, User host, Region region) {
		this.accommodationName = accommodationName;
		this.description = description;
		this.type = type;
		this.price = price;
		this.mainImage = mainImage;
		this.vat = vat;
		this.address = address;
		this.details = details;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.host = host;
		this.region = region;
	}

	@Id
	@Column(name = "accommodation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String accommodationName;

	@Column(name = "accommodation_description")
	private String description;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "accommodation_type")
	private AccommodationType type;

	@NotNull
	private int price;

	private String mainImage;

	@Embedded
	private Vat vat;

	@NotNull
	@Embedded
	private Address address;

	@Embedded
	private AccommodationDetails details;

	@NotNull
	@Max(24)
	private Integer checkInTime;

	@NotNull
	@Max(24)
	private Integer checkOutTime;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User host;

	@OneToMany(mappedBy = "accommodation")
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "accommodation")
	private List<Reservation> reservations = new ArrayList<>();

	@OneToMany(mappedBy = "accommodation")
	private List<AccommodationImage> images = new ArrayList<>();

	@Enumerated(value = EnumType.STRING)
	private DiscountPolicy discountPolicy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private Event event;

	@NotNull
	@OneToOne
	@JoinColumn(name = "region_id")
	private Region region;

	@Transient
	private double starRating;

	@Transient
	private static final double TAX = 0.1;

	@Transient
	private static final double ONE_WEEK = 7.0;

	public void calcStarRating(){
		double ratingSum = this.reviews.stream()
			.mapToDouble(Review::getStarRating)
			.sum();
		this.starRating = ratingSum / (reviews.isEmpty() ? 1 : reviews.size());
	}

	public List<String> getImageUrls() {
		return this.images.stream()
			.map(AccommodationImage::getUrl)
			.collect(Collectors.toList());
	}

	public PreviewResponse previewReservationFee(int duration) {
		return new PreviewResponse(
			calculateRegularPrice(duration),
			calculateDiscount(duration),
			calculateCleaningFee(),
			calculateServiceFee(),
			calculateAccommodationTax(),
			calculateTotalPrice(duration));
	}

	public int calculateTotalPrice(int duration){
		int regularPrice = calculateRegularPrice(duration);
		int discount = calculateDiscount(duration);
		int accommodationTax = calculateAccommodationTax();
		int cleaningFee = calculateCleaningFee();
		int serviceFee = calculateServiceFee();
		return regularPrice - discount + accommodationTax + cleaningFee + serviceFee;
	}

	public int calculateRegularPrice(int duration) {
		return this.price * duration;
	}

	public int calculateDiscount(int duration) {
		return (int) (this.discountPolicy.getRate() * (duration / ONE_WEEK) * this.price);
	}

	public int calculateAccommodationTax() {
		return (int) (this.vat.getServiceFee() * this.price * TAX);
	}

	public int calculateCleaningFee() {
		return (int) (this.price * this.vat.getCleaningFee());
	}

	public int calculateServiceFee() {
		return (int) (this.price * this.vat.getServiceFee());
	}

}
