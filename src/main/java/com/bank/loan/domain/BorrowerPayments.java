package com.bank.loan.domain;

import java.util.List;

public class BorrowerPayments {
    List<Payment> borrowerPayments;

    public List<Payment> getBorrowerPayments() {
        return borrowerPayments;
    }

    public void setBorrowerPayments(List<Payment> borrowerPayments) {
        this.borrowerPayments = borrowerPayments;
    }
}
