package com.acme.banking.dbo.ooad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdraw(long id, double amount) {
        accountRepository.getClientById(id).withdraw(amount);
    }

    public void transfer(long fromClientId, long toClientId, long amount) {
        System.out.printf("transfer start: from = %d, to = %d, amount = %d\n", fromClientId, toClientId, amount);
        accountRepository.getClientById(fromClientId).withdraw(amount);
        accountRepository.getClientById(toClientId).topUp(amount);
        System.out.printf("transfer end: from = %d, to = %d\n", fromClientId, toClientId);
    }
}
