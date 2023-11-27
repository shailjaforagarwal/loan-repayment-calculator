package com.bank.loan.controller;

import com.bank.loan.domain.BorrowerPayments;
import com.bank.loan.domain.Payment;
import com.bank.loan.domain.ReceivedPayload;
import com.bank.loan.service.CalculateRepayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanCalculatorController {
@Autowired
CalculateRepayment calculateRepayment;
    @PostMapping(value = "api/v1/getLoanRepaymentDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BorrowerPayments> loanRepaymentPlan(@RequestBody ReceivedPayload json){
        List<Payment> loanRepaymentList = calculateRepayment.getPaymentsList(json);
        BorrowerPayments paymentList = new BorrowerPayments();
        paymentList.setBorrowerPayments(loanRepaymentList);
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }
}
