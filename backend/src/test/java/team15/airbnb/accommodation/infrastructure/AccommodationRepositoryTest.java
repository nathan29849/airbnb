package team15.airbnb.accommodation.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team15.airbnb.accommodation.domain.*;
import team15.airbnb.category.domain.Region;
import team15.airbnb.category.infrastructure.RegionRepository;
import team15.airbnb.user.domain.User;
import team15.airbnb.user.domain.UserType;
import team15.airbnb.user.infrastructure.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AccommodationRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Test
    @DisplayName("숙소를 저장한다.")
    void save() throws ParseException {

        Vat vat = new Vat(5.0, 1.0, 10.0);

        Double latitude = 32.123;
        Double longitude = 127.123;
        String pointWKT = String.format("POINT(%s %s)", longitude, latitude);
        Point point = (Point) new WKTReader().read(pointWKT);


        Address address = new Address(Country.SOUTH_KOREA, City.SEOUL, "노원구 노원로 10000", "100동 1000호", "12345", point);
        AccommodationDetails details = new AccommodationDetails(4, 2, 2, 1);


        User user = new User("포키", UserType.HOST, "profile image");
        userRepository.save(user);

        Region region = new Region(City.SEOUL, "region image url", point);
        regionRepository.save(region);

        Accommodation accommodation = new Accommodation("숙소 1", "좋아요", AccommodationType.HOTEL, 80000, "image url", vat, address,  details,  14, 12, user, region);
        accommodationRepository.save(accommodation);

        em.flush();
        em.clear();

        Accommodation findAccommodation = accommodationRepository.findById(accommodation.getId());

        System.out.println(findAccommodation.getAddress().getCoordinate());

        assertThat(findAccommodation.getAccommodationName()).isEqualTo("숙소 1");
        assertThat(findAccommodation.getHost().getName()).isEqualTo("포키");
    }



}
