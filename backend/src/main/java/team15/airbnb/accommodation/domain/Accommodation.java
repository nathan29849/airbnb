package team15.airbnb.accommodation.domain;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team15.airbnb.category.domain.Region;
import team15.airbnb.common.domain.BaseEntity;
import team15.airbnb.category.domain.Event;
import team15.airbnb.reservation.domain.Reservation;
import team15.airbnb.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
	private DiscountPolicy discountPolicy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private Event event;

	@NotNull
	@OneToOne
	@JoinColumn(name = "region_id")
	private Region region;

	@Transient
	double starRating;

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

}
