package com.acme.banking.dbo.ooad;

import static org.fest.assertions.api.Assertions.assertThat;
import com.acme.banking.dbo.ooad.domain.CheckingAccount;
import com.acme.banking.dbo.ooad.domain.SavingAccount;
import com.acme.banking.dbo.ooad.service.AccountRepository;
import com.acme.banking.dbo.ooad.service.ConvertingService;
import com.acme.banking.dbo.ooad.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring-context.xml"})
public class LauncherTest {
//    ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//    ConvertingService convertingService = (ConvertingService) context.getBean("nostalgieConvertingService");
//    TransferService transferService = (TransferService) context.getBean("transferService");

//    convertingService.getRubAmountInUsd(12000);
//    transferService.withdraw(123, 100);
//    transferService.transfer(123, 456, 200);

    @Autowired private TransferService transferService;
    @MockBean private AccountRepository accountRepository;

    @Test
    public void userShouldBeAbleToTransferMoney() {
        when(accountRepository.getClientById(666)).thenReturn(new SavingAccount(666, 666));
        when(accountRepository.getClientById(777)).thenReturn(new CheckingAccount(777, 777, 777));

        assertThat(accountRepository.getClientById(666)).isEqualsToByComparingFields(new SavingAccount(666, 666));
    }

    @Test
    public void userShouldntBeAbleToWithdrawTooMuchMoney() {
        when(accountRepository.getClientById(666)).thenReturn(new SavingAccount(666, 100));

        try {
            transferService.withdraw(666, 200);
        } catch (IllegalStateException e) {
            assertThat(e).hasMessage("Not enough funds to withdraw");
        }
    }
}
