package fr.valtech.meetup.web.welcome;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome";
    }
}
