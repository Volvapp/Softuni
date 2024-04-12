package org.springintro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springintro.data.entities.Account;
import org.springintro.data.repositories.AccountRepository;
import org.springintro.service.AccountService;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(Account account) {
        this.accountRepository.saveAndFlush(account);
    }

    @Override
    public void withdrawMoney(BigDecimal money, Integer id) {
        Optional<Account> byId = this.accountRepository.findById(id);
        if (byId.isPresent()) {
            Account account = byId.get();
            if (account.getBalance().compareTo(money) >= 0) {
                account.setBalance(account.getBalance().subtract(money));
                this.accountRepository.saveAndFlush(account);
            }
        }
    }

    @Override
    public void transferMoney(BigDecimal money, Integer id) {

    }
}
