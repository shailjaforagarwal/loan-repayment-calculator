package com.bank.loan.service;
import com.bank.loan.common.LoanConstants;
import com.bank.loan.domain.Payment;
import com.bank.loan.domain.RequestPayload;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateRepayment {
    public List<Payment> getPaymentsList(RequestPayload loanDetails){
         List<Payment> paymentList = new ArrayList<>();
         double monthlyInterestRate = getInterestRate(loanDetails.getNominalRate());
         double annuity = getAnnuity(monthlyInterestRate,loanDetails.getDuration(),loanDetails.getLoanAmount());
         LocalDate startDate = getStartDateVal(loanDetails.getStartDate());

         calculatePayments(paymentList, loanDetails.getLoanAmount(),annuity, loanDetails.getNominalRate(),startDate);
         return paymentList;
    }

    private LocalDate getStartDateVal(String startDate) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(startDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        }
        catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double getInterestRate(double nominalRate) {
         return nominalRate/12;
     }

     private double getAnnuity(double rate,int duration, double amount) {
        double interestRate = rate/100;
         double annuity = (interestRate * amount)/(1-Math.pow(1+interestRate,-1*duration));
         return annuity;
     }

     private void calculatePayments(List<Payment> paymentList, double amount, double annuity, double rate, LocalDate startDate) {
         double outstandingPrincipal = amount;
         LocalDate paymentDate = startDate;
         do {
            double interest = (rate/100)* LoanConstants.DAYS_IN_MONTH*outstandingPrincipal / LoanConstants.DAYS_IN_YEAR;
             double principal = annuity - interest;
             if(principal > outstandingPrincipal){
                 principal = outstandingPrincipal;
             }
            double remainingOutstandingPrincipal = outstandingPrincipal - principal;
             DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
             String dateStr = paymentDate.format(formatters);
             Payment payment = new Payment();
            payment.setInitialOutStandingPrincipal(outstandingPrincipal);
            payment.setInterest(interest);
            payment.setPrincipal(principal);
            payment.setBorrowerPaymentAmount(annuity);
            payment.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);
            payment.setDate(dateStr);
            paymentList.add(payment);
            outstandingPrincipal = remainingOutstandingPrincipal;
            paymentDate = paymentDate.plusMonths(1);
        }while(outstandingPrincipal > 0);
     }
}
