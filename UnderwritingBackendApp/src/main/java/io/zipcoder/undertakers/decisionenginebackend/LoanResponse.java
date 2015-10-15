package io.zipcoder.undertakers.decisionenginebackend;

/**
 * Created by abrown on 10/15/15.
 */
public class LoanResponse {
    boolean approved;
    int maxLoan;
    int monthlyPayment;
    int repaymentTerm;

    public LoanResponse(boolean approved, int maxLoan, int monthlyPayment, int repaymentTerm) {
        this.approved = approved;
        this.maxLoan = maxLoan;
        this.monthlyPayment = monthlyPayment;
        this.repaymentTerm = repaymentTerm;
    }

    public boolean getApproved(){
        return approved;
    }

    public int getMaxLoan(){
        return maxLoan;
    }

    public int getMonthlyPayment(){
        return monthlyPayment;
    }

    public int getRepaymentTerm(){
        return repaymentTerm;
    }
}
