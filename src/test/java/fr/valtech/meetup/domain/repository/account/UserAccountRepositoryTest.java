package fr.valtech.meetup.domain.repository.account;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import fr.valtech.meetup.domain.model.account.UserAccount;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private TestEntityManager entityManager;

    private String email = "admin@gmail.com";

    private String firstName = "Jean";

    private String lastName = "Martin";

    private String password = "password";

    private String role = "ADMIN";

    private UserAccount creatDummyUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(email);
        userAccount.setFirstName(firstName);
        userAccount.setLastName(lastName);
        userAccount.setPassword(password);
        userAccount.setRole(role);
        return userAccount;
    }

    @Test
    public void persist() {
        UserAccount userAccount = entityManager.persistFlushFind(creatDummyUserAccount());

        assertThat(userAccount).isNotNull();
        assertThat(userAccount.getId()).isNotNull();
        assertThat(userAccount.getEmail()).isEqualTo(email);
        assertThat(userAccount.getFirstName()).isEqualTo(firstName);
        assertThat(userAccount.getLastName()).isEqualTo(lastName);
        assertThat(userAccount.getPassword()).isEqualTo(password);
        assertThat(userAccount.getRole()).isEqualTo(role);
    }

    @Test
    public void findByEmail() {
        entityManager.persistAndFlush(creatDummyUserAccount());

        assertThat(userAccountRepository.findByEmail("x.y@z.com")).isNull();

        UserAccount userAccount = userAccountRepository.findByEmail(email);

        assertThat(userAccount).isNotNull();
        assertThat(userAccount.getEmail()).isEqualTo(email);
    }
}
