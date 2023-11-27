package com.bank.loan.domain;
import java.time.LocalDate;

public class Payment {

    private double borrowerPaymentAmount;
    private String date;
    private double initialOutStandingPrincipal;
    private double interest;
    private double principal;
    private double remainingOutstandingPrincipal;

    public double getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
        this.borrowerPaymentAmount = Math.round(borrowerPaymentAmount * 100.0) / 100.0;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getInitialOutStandingPrincipal() {
        return initialOutStandingPrincipal;
    }

    public void setInitialOutStandingPrincipal(double initialOutStandingPrincipal) {
        this.initialOutStandingPrincipal = Math.round(initialOutStandingPrincipal * 100.0) / 100.0;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = Math.round(interest * 100.0) / 100.0;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = Math.round(principal * 100.0) / 100.0;;
    }

    public double getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = Math.round(remainingOutstandingPrincipal * 100.0) / 100.0;;
    }
}
