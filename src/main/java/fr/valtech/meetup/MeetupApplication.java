package fr.valtech.meetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.valtech.meetup.domain.model.account.UserAccount;
import fr.valtech.meetup.domain.service.account.UserAccountService;

@SpringBootApplication
public class MeetupApplication implements CommandLineRunner {

    @Autowired(required = false)
    private UserAccountService userAccountService;

    public static void main(String[] args) {
        SpringApplication.run(MeetupApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String email = "admin@gmail.com";

        if (userAccountService != null) {
            UserAccount userAccount = userAccountService.findUserAccountByEmail(email);
            if (userAccount == null) {
                userAccount = new UserAccount();
                userAccount.setEmail(email);
                userAccount.setFirstName("Jean");
                userAccount.setLastName("Martin");
                userAccount.setPassword("123soleil");
                userAccount.setRole("ROLE_ADMIN");
                userAccountService.addUserAccount(userAccount);
            }

            email = "user@gmail.com";
            userAccount = userAccountService.findUserAccountByEmail(email);
            if (userAccount == null) {
                userAccount = new UserAccount();
                userAccount.setEmail(email);
                userAccount.setFirstName("Gilles");
                userAccount.setLastName("Bonnet");
                userAccount.setPassword("123soleil");
                userAccount.setRole("ROLE_USER");
                userAccountService.addUserAccount(userAccount);
            }
        }
    }
}
