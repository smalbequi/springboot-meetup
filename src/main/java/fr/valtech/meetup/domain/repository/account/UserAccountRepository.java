package fr.valtech.meetup.domain.repository.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import fr.valtech.meetup.domain.model.account.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByEmail(String email);
}
