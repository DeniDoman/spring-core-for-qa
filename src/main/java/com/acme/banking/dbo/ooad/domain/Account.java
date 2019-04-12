package com.acme.banking.dbo.ooad.domain;

public interface Account extends Withdrawable, Topupable {
    long getId();
}
