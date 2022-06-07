package team15.airbnb.accommodation.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import team15.airbnb.user.domain.UserType;


@Getter
@NoArgsConstructor
public class AccommodationSimpleInfoResponse {

    private Long accommodationId;
    private boolean like;
    private boolean superHost;
    private String accommodationName;
    private String mainImage;
    private Double starRating;
    private Integer reviewCount;
    private Integer price;
    private int totalPrice;
    private double longitude;
    private double latitude;

    public AccommodationSimpleInfoResponse(Long accommodationId, Boolean like, UserType host, String accommodationName, String mainImage, Double starRating, Integer reviewCount, Integer price, String coordinate) throws ParseException {
        this.accommodationId = accommodationId;
        this.like = like;
        this.superHost = host.isSuperHost();
        this.accommodationName = accommodationName;
        this.mainImage = mainImage;
        this.starRating = starRating;
        this.reviewCount = reviewCount;
        this.price = price;
        this.totalPrice = 0;
        Point point = (Point) new WKTReader().read(coordinate);
        this.longitude = point.getY();
        this.latitude = point.getX();
    }
}
