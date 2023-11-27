package com.bank.loan.service;

import com.bank.loan.domain.Payment;
import com.bank.loan.domain.ReceivedPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LoanServiceTest {
    @Autowired
    CalculateRepayment calculateRepaymentService;

    @Test
    public void testCalculateRepayment(){
        ReceivedPayload payload = new ReceivedPayload(5000.0, 5.0, 24, "01-05-2024");
        List<Payment> listOfPayments = calculateRepaymentService.getPaymentsList(payload);
        Assertions.assertTrue(!listOfPayments.isEmpty());
    }
}
