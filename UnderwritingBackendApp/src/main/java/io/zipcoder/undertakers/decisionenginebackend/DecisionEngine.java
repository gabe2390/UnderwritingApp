package io.zipcoder.undertakers.decisionenginebackend;

/**
 * DecisionEngine
 * @author Gregory Furlong
 */
public class DecisionEngine {
    final public static int MAXIMUM_NON_HOUSE_LOAN = 50000;

    private int id;
    private int minCredit;
    private int minIncome;
    private int maxDebt;
    private int minAssetPoints;

    private int maxAmount;
    private int term;

    /**
     * DecisionEngine constructor
     * @param minCredit         The minimum credit allowed by this decision engine
     * @param minIncome         The minimum income to qualify for this engine
     * @param maxDebt           The maximum debt to qualify for this engine
     * @param minAssetPoints    The minimum assets to qualify for this engine
     * @param id                The id of this engine
     */
    public DecisionEngine(int minCredit, int minIncome, int maxDebt, int minAssetPoints, int id) {
        this.id = id;
        this.minCredit = minCredit;
        this.minIncome = minIncome;
        this.maxDebt = maxDebt;
        this.minAssetPoints = minAssetPoints;

        this.maxAmount = (int) (Math.random()*490000)+10000;
        if(this.maxAmount < 30000) {
            // 3 years
            this.term = 36;
        }
        else {
            // 3 to 30 years
            this.term = Math.min((this.maxAmount / 10000)*12, 360);
        }
    }

    /**
     *  Calculate the monthly payment required to amortize a loan with the passed interest and amount
     *  in the specified term
     *
     * (formula from http://www.mtgprofessor.com/formulas.htm)
     * P = L[c(1+c)^n]/[(1+c)^n - 1]
     * @param amount        The amount in whole dollars (L)
     * @param interest      The annual interest rate in hundredths of a percent (c * 1200)
     * @param term          The term in months (n)
     * @return              The monthly payment
     */
    public static double calculateMonthlyPayment(int amount, int interest, int term){
        // check for term of zero
        if(term == 0) {
            throw new IllegalArgumentException("Argument 'term' was passed as the value '0'");
        }
        // check for interest rate of 0 (would cause division by zero)
        else if(interest == 0) {
            return amount / ((double) term);
        }

        double c = interest / 120000f;

        return amount * (c * Math.pow(1+c,term)) / (Math.pow(1+c, term) - 1);
    }

    /**
     * Get id
     * @return  this decision engine's id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get min credit
     * @return  This decision engine's minimum credit
     */
    public int getMinCredit() {
        return this.minCredit;
    }

    /**
     * Get max debt
     * @return  this decision engine's max debt
     */
    public int getMaxDebt() {
        return this.maxDebt;
    }

    /**
     * Get minimum income
     * @return  the minimum income
     */
    public int getMinIncome() {
        return this.minIncome;
    }

    /**
     * Get minimum asset points
     * @return  this decision engine's minimum asset points
     */
    public int getMinAssetPoints() {
        return this.minAssetPoints;
    }

    /**
     * Get max amount
     * @return      the maximum loan that can be issued
     */
    public int getMaxAmount() {
        return this.maxAmount;
    }

    /**
     * Get the term of the loan in months
     * @return      the term of the loan in months
     */
    public int getTerm() {
        return this.term;
    }

    /**
     * Check if a loanRequest is approved
     * @param loanRequest   A loan request to test
     * @return              A boolean indicating if the request is approved
     */
    public boolean isApproved(LoanRequest loanRequest) {
        Person applicant = loanRequest.getApplicant();

        return  // check credit
                applicant.lookupCreditScore() > this.minCredit
                // check income
                && applicant.getTotalIncome() > this.minIncome
                // check debt
                && applicant.getDebt() < this.maxDebt
                // check asset points
                && applicant.getAssetScore() > this.minAssetPoints
                // reject the loan if its more than 50000 and for something other than a house
                && (loanRequest.getReason().toLowerCase().equals("house")
                    || loanRequest.getAmount() < MAXIMUM_NON_HOUSE_LOAN);
    }

    /**
     * Generate a response based on the passed loanRequest
     * @return      A loan request containing the terms of the loan
     */
    public LoanResponse generateResponse(LoanRequest loanRequest) {
        boolean approved = this.isApproved(loanRequest);
        int maxAmount = Math.min(this.getMaxAmount(),loanRequest.getAmount());
        int repaymentTerm = this.getTerm();

        // TODO either configurable interest rate OR randomly generated?
        // (seem to range from 3 to 4 for housing in real life)
        int interest = 400;  // in hundredths of a percent
        int monthPayment = (int) calculateMonthlyPayment(maxAmount, interest, repaymentTerm);

        return new LoanResponse(approved, maxAmount, monthPayment, repaymentTerm);
    }
}
