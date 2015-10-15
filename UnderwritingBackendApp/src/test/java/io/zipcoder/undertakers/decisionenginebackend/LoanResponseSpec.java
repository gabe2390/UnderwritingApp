package io.zipcoder.undertakers.decisionenginebackend;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by abrown on 10/15/15.
 */
public class LoanResponseSpec {
    LoanResponse loanResponse;
    @Before
    public void createLoanResponse(){
        loanResponse = new LoanResponse(true, 10000, 200, 48);
    }

    @Test
    public void LoanResponseTester(){
        Assert.assertEquals("Test the approved getter", true, loanResponse.getApproved());
        Assert.assertEquals("Test the approved getter", 10000, loanResponse.getMaxLoan());
        Assert.assertEquals("Test the approved getter", 200, loanResponse.getMonthlyPayment());
        Assert.assertEquals("Test the approved getter", 48, loanResponse.getRepaymentTerm());
    }
}
