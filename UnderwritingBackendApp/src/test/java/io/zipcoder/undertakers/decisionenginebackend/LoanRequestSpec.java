package io.zipcoder.undertakers.decisionenginebackend;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by abrown on 10/15/15.
 */
public class LoanRequestSpec {
    Job job = new Job("Developer", 99999999, "Sparks and friends", "Tech");
    Job[] jobArray = {job};
    Asset asset = new Asset("Car", "Ole' faithful", 27000);
    Asset[] assetArray = {asset};
    Person person = new Person("Rick", "Sparks", 26, "000-00-0000", true, jobArray,0, false, 1000,assetArray);


    LoanRequest loanRequest;

    @Before
    public void createLoanResponse(){
        loanRequest = new LoanRequest(10000, "Car", 24, person);
    }

    @Test
    public void LoanRequestTester(){
        Assert.assertEquals("Check to make sure the getter returns the correct value", 10000, loanRequest.getAmount());
        Assert.assertEquals("Check to make sure the getter returns the correct value", "Car", loanRequest.getReason());
        Assert.assertEquals("Check to make sure the getter returns the correct value", 24, loanRequest.getRepaymentTerm());
        Assert.assertEquals("Check to make sure the getter returns the correct value", person, loanRequest.getApplicant());
    }
}
