package com.acme.banking.dbo.ooad.domain;

/**
 * Immutable
 */
public class CheckingAccount extends SavingAccount { //IS-A
    private double overdraft;

    public CheckingAccount(long id, double amount, double overdraft) {
        super(id, amount);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    protected boolean validate(double amount) {
        return super.validate(amount - overdraft);
    }
}
