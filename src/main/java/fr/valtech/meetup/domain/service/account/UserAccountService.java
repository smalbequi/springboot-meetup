package fr.valtech.meetup.domain.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import fr.valtech.meetup.domain.model.account.UserAccount;
import fr.valtech.meetup.domain.repository.account.UserAccountRepository;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public Page<UserAccount> findAllUserAccounts(int page, int size) {
        return userAccountRepository.findAll(new PageRequest(page, size));
    }

    public UserAccount findUserAccountByEmail(String username) {
        return userAccountRepository.findByEmail(username);
    }

    public void addUserAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);

    }
}
