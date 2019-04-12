package com.acme.banking.dbo.ooad;

import com.acme.banking.dbo.ooad.service.ConvertingService;
import com.acme.banking.dbo.ooad.service.TransferService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        double d = 30;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ConvertingService convertingService = (ConvertingService) context.getBean("nostalgieConvertingService");
        TransferService transferService = (TransferService) context.getBean("transferService");

        convertingService.getRubAmountInUsd(12000);
        transferService.withdraw(123, 100);
        transferService.transfer(123, 456, 200);


    }
}
