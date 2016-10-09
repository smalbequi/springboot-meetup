package fr.valtech.meetup.web.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fr.valtech.meetup.domain.model.account.UserAccount;
import fr.valtech.meetup.domain.service.account.UserAccountService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("accounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @Secured("ROLE_ADMIN")
    @ApiOperation(value = "Service permettant de récupérer tous les comptes utilisateurs")
    @RequestMapping(method = RequestMethod.GET)
    public Page<UserAccount> accounts(@RequestParam int page, @RequestParam int size) {
        return userAccountService.findAllUserAccounts(page, size);
    }
}
