package io.zipcoder.undertakers.decisionenginebackend;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Specification and unit tests for Decision Engine class
 * @author Gregory Furlong
 */
public class DecisionEngineSpec {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private DecisionEngine decisionEngine;
    private LoanRequest loanRequest;
    private Person person;

    @Before
    public void before() {
        this.loanRequest = mock(LoanRequest.class);
        this.person = mock(Person.class);

        when(this.loanRequest.getAmount()).thenReturn(75000);
        when(this.loanRequest.getReason()).thenReturn("house");
        when(this.loanRequest.getApplicant()).thenReturn(this.person);

        when(this.person.lookupCreditScore()).thenReturn(650);
        when(this.person.getTotalIncome()).thenReturn(60000);
        when(this.person.getDebt()).thenReturn(150000);
        when(this.person.getAssetScore()).thenReturn(75);

        this.decisionEngine = new DecisionEngine(600, 50000, 200000, 50, 1);
    }

    @Test
    public void testIsApprovedReturnsTrue() {
        assertEquals("Should return true by default", true, this.decisionEngine.isApproved(this.loanRequest));
    }

    @Test
    public void testIsApprovedFailsIfLowCredit() {
        when(this.person.lookupCreditScore()).thenReturn(450);
        // get the first mocked credit score
        this.person.lookupCreditScore();
        assertEquals("Should fail if credit is too low", false, this.decisionEngine.isApproved(this.loanRequest));
    }

    @Test
    public void testIsApprovedFailsIfLowIncome() {
        when(this.person.getTotalIncome()).thenReturn(40000);
        // get the first mocked income
        this.person.getTotalIncome();
        assertEquals("Should fail if income is too low", false, this.decisionEngine.isApproved(this.loanRequest));
    }

    @Test
    public void testIsApprovedFailsIfHighDebt() {
        when(this.person.getDebt()).thenReturn(250000);
        // get the first mocked debt
        this.person.getDebt();
        assertEquals("Should fail if debt is too high", false, this.decisionEngine.isApproved(this.loanRequest));
    }

    @Test
    public void testIsApprovedFailsIfLowAssets() {
        when(this.person.getAssetScore()).thenReturn(49);
        // get the first mocked asset score
        this.person.getAssetScore();
        assertEquals("Should fail if asset is too low", false, this.decisionEngine.isApproved(this.loanRequest));
    }

    @Test
    public void testIsApprovedFailsIfNotHouseAndTooHigh() {
        when(this.loanRequest.getReason()).thenReturn("car");
        when(this.loanRequest.getAmount()).thenReturn(DecisionEngine.MAXIMUM_NON_HOUSE_LOAN + 1);

        // get the first mocked reason and amount
        this.loanRequest.getReason();
        this.loanRequest.getAmount();

        assertEquals("Should fail if reason is not house and amount too high", false, this.decisionEngine.isApproved(this.loanRequest));
    }

    @Test
    public void testCalculateMonthlyPaymentThrowsInvalidArgumentException() {
        this.expectedException.expect(IllegalArgumentException.class);
        // Should throw exception with term length of zero
        DecisionEngine.calculateMonthlyPayment(500, 500, 0);
    }

    @Test
    public void testCalculateMonthlyPayment() {
        int amount = 50000;
        int interest = 600;
        int term = 120;

        double calculated = DecisionEngine.calculateMonthlyPayment(amount,interest,term);
        assertEquals("Monthly payment should be within 0.01 of correct value", 555.1025097082559, calculated, 0.01);
    }

    @Test
    public void testGenerateResponseIsApprovedTest() {
        LoanResponse response = this.decisionEngine.generateResponse(loanRequest);
        assertTrue("Loan response should be approved", response.getApproved());
    }

    @Test
    public void testGenerateResponseIsNotApprovedTest() {
        when(this.person.lookupCreditScore()).thenReturn(450);
        // get the first mocked credit score
        this.person.lookupCreditScore();

        LoanResponse response = this.decisionEngine.generateResponse(loanRequest);
        assertFalse("Loan response should not be approved", response.getApproved());
    }
}
