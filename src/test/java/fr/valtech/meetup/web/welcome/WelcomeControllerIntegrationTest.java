package fr.valtech.meetup.web.welcome;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("security-disabled")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WelcomeControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void welcome() {
        ResponseEntity<String> response = restTemplate.getForEntity("/welcome", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Welcome");
    }

}
