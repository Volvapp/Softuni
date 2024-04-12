package org.springintro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springintro.data.entities.Account;
import org.springintro.data.entities.User;
import org.springintro.service.AccountService;
import org.springintro.service.UserService;

import java.math.BigDecimal;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private final UserService userService;
    @Autowired
    private final AccountService accountService;

    public CommandLineRunnerImpl(UserService userService, AccountService accountService) {

        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = this.userService.findUserById(1);
        Account account = new Account(BigDecimal.valueOf(50005), user);
        this.accountService.createAccount(account);
        System.out.println();

    }
}
