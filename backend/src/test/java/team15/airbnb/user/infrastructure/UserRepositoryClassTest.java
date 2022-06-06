package team15.airbnb.user.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team15.airbnb.user.domain.User;
import team15.airbnb.user.domain.UserType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserRepositoryClassTest {


    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저를 저장한다.")
    void save() {
        User user = new User("포키", UserType.HOST, "http://profile-image");
        userRepository.save(user);

        em.flush();
        em.clear();

        User findUser = userRepository.findById(user.getId());

        assertThat(findUser.getName()).isEqualTo("포키");
    }

    @Test
    @DisplayName("전체 유저 목록을 조회한다.")
    void findAll() {
        User user1 = new User("포키", UserType.HOST, "http://profile-image");
        User user2 = new User("리아코", UserType.HOST, "http://profile-image");
        User user3 = new User("산토리", UserType.CUSTOMER, "http://profile-image");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        em.flush();
        em.clear();

        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers.size()).isEqualTo(3);
    }



}
