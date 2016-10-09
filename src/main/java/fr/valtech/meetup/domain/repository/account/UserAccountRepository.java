package fr.valtech.meetup.domain.repository.account;

import org.springframework.data.repository.PagingAndSortingRepository;
import fr.valtech.meetup.domain.model.account.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

    UserAccount findByEmail(String email);
}
