package com.acme.banking.dbo.ooad.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NostalgieConvertingService implements ConvertingService {
    private double rate;

    public NostalgieConvertingService(@Value("30") double rate) {
        this.rate = rate;
    }

    @Override
    public double getRubAmountInUsd(double rubAmount) {
        System.out.printf("converting: rubAmount = %f, result = %f\n", rubAmount, rubAmount / rate);
        return rubAmount / rate;
    }
}
