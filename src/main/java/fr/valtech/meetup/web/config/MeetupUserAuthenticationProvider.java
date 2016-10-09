package fr.valtech.meetup.web.config;

import static com.google.common.collect.Lists.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import fr.valtech.meetup.domain.model.account.UserAccount;
import fr.valtech.meetup.domain.service.account.UserAccountService;

@Service
public class MeetupUserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        // Nothing to do
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String password = (String) authentication.getCredentials();

        UserAccount account = userAccountService.findUserAccountByEmail(username);

        if (account == null || !account.getPassword().equals(password)) {
            throw new BadCredentialsException("Bad credentials for usernane " + username);
        }
        else {
            return new User(username, "SECRET", newArrayList(new SimpleGrantedAuthority(account.getRole())));
        }
    }
}
