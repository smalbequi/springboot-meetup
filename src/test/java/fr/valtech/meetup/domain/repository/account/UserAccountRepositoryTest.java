package fr.valtech.meetup.domain.repository.account;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import fr.valtech.meetup.domain.model.account.UserAccount;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Before
    public void before() {
        userAccountRepository.deleteAll();
    }

    @Test
    public void save() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("admin@gmail.com");

        userAccountRepository.save(userAccount);
        assertThat(userAccount.getId()).isNotNull();
    }

    @Test
    public void findByEmail() {
        assertThat(userAccountRepository.findByEmail("x.y@z.com")).isNull();

        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("admin@gmail.com");

        userAccountRepository.save(userAccount);

        assertThat(userAccountRepository.findByEmail("admin@gmail.com")).isNotNull();
    }

}
