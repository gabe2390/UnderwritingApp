package io.zipcoder.undertakers.decisionenginebackend;

/**
 * Created by abrown on 10/15/15.
 */
public class LoanRequest {
    int amount;
    String reason;
    int repaymentTerm;
    Person applicant;

    /**
     * Constructor
     * @param amount
     * @param reason
     * @param repaymentTerm
     * @param applicant
     */
    public LoanRequest(int amount, String reason, int repaymentTerm, Person applicant) {
        this.amount = amount;
        this.reason = reason;
        this.repaymentTerm = repaymentTerm;
        this.applicant = applicant;
    }


    /**
     * Getters
     */
    public int getAmount(){return amount; }
    public String getReason(){return reason; }
    public int getRepaymentTerm(){return repaymentTerm; }
    public Person getApplicant(){return applicant;}

}
