package com.acme.banking.dbo.ooad.domain;

public class SavingAccount implements Account,Withdrawable,Topupable {
    private long id;
    private double amount;

    public SavingAccount(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    @Override //Template method
    public void withdraw(double amount) {
        System.out.printf("withdraw start: id = %d, withdrawAmount = %f, userAmount = %f\n", id, amount, this.amount);
        if (validate(amount)) {
            throw new IllegalStateException("Not enough funds to withdraw");
        }

        this.amount -= amount;
        System.out.printf("withdraw end: id = %d, userAmount = %f\n", id, this.amount);
    }

    @Override //Template method
    public void topUp(double amount) {
        System.out.printf("topUp start: id = %d, topUpAmount = %f, userAmount = %f\n", id, amount, this.amount);
        this.amount += amount;
        System.out.printf("topUp end: id = %d, userAmount = %f\n", id, this.amount);
    }

    //step
    protected boolean validate(double amount) {
        return amount > this.amount;
    }
}
