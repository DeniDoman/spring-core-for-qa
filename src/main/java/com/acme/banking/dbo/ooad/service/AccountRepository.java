package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.domain.Account;

public interface AccountRepository {
    Account getClientById(long id);
}
