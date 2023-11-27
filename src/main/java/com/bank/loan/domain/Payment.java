package com.bank.loan.domain;
import java.time.LocalDate;

public class Payment {

    private double borrowerPaymentAmount;
    private LocalDate date;
    private double initialOutStandingPrincipal;
    private double interest;
    private double principal;
    private double remainingOutstandingPrincipal;

    public double getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getInitialOutStandingPrincipal() {
        return initialOutStandingPrincipal;
    }

    public void setInitialOutStandingPrincipal(double initialOutStandingPrincipal) {
        this.initialOutStandingPrincipal = initialOutStandingPrincipal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }
}
