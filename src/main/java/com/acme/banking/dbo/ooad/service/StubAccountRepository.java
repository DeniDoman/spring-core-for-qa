package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.domain.CheckingAccount;
import com.acme.banking.dbo.ooad.domain.SavingAccount;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StubAccountRepository implements AccountRepository {
    private List<Account> clients = Arrays.asList(new SavingAccount(123,1000), new CheckingAccount(456, 5000, 100));

    @Override
    public Account getClientById(long id) {
        for (Account w : clients) {
            if (w.getId() == id)
                return w;
        }
        return null;
    }
}
