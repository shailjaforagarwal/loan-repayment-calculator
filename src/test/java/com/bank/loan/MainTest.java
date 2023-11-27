package com.bank.loan;

import com.bank.loan.controller.LoanCalculatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainTest {

    @Autowired
    LoanCalculatorController controller;

    @Test
    void contextLoads(){
        Assertions.assertNotNull(controller);
    }
}
