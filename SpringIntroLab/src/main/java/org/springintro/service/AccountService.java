package org.springintro.service;

import org.springintro.data.entities.Account;

import java.math.BigDecimal;

public interface AccountService {
void createAccount(Account account);
    void withdrawMoney(BigDecimal money, Integer id);
    void transferMoney(BigDecimal money, Integer id);
}
