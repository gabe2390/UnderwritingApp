package io.zipcoder.undertakers.decisionenginebackend;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by ghumphrey on 10/16/15.
 */
public class LoanAppSpec {
    LoanApp app;
    List<DecisionEngine> engines = new ArrayList<>();

    LoanRequest request;
    LoanResponse response;

    DecisionEngine trueEngine = mock(DecisionEngine.class);
    DecisionEngine falseEngine = mock(DecisionEngine.class);

    @Before
    public void before(){
        this.request = mock(LoanRequest.class);
        this.app = new LoanApp(this.engines, this.request);

        response = mock(LoanResponse.class);

        // true engine setup
        this.trueEngine = mock(DecisionEngine.class);
        when(this.trueEngine.isApproved(any())).thenReturn(true);
        when(this.trueEngine.generateResponse(any())).thenReturn(this.response);

        // false engine setup
        this.falseEngine = mock(DecisionEngine.class);
        when(this.falseEngine.isApproved(any())).thenReturn(false);
        when(this.falseEngine.generateResponse(any())).thenReturn(this.response);
    }

    @Test
    public void testGenerateResponsesAllApproved() {
        for(int i =0; i < 10; i++) {
            this.engines.add(this.trueEngine);
        }
        this.app.generateResponses();

        assertEquals("Generate responses creates a LoanResponse for each engine", this.engines.size(), this.app.getResponses().size());
    }

    @Test
    public void testGenerateResponseTwoApproved() {
        for(int i =0; i < 10; i++) {
            this.engines.add(this.falseEngine);
        }
        this.engines.add(this.trueEngine);
        this.engines.add(this.trueEngine);
        this.app.generateResponses();

        assertEquals("Generate responses creates a LoanResponse for only the two positive engines", 2, this.app.getResponses().size());
    }
}
