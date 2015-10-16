package io.zipcoder.undertakers.decisionenginebackend;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ghumphrey on 10/16/15.
 */
public class LoanAppSpec {
    LoanApp app;
    List<DecisionEngine> trueEngines= new ArrayList<>();
    List<DecisionEngine> falseEngines= new ArrayList<>();
    LoanRequest request;
    Person p;

    @Test
    public void testGenerateResponses(){
        p= new Person("g","h",1,"2",true,new Job[1], 3,false,100,new Asset[2]);//Person for testing

        trueEngines.add(new DecisionEngine());
        trueEngines.add(new DecisionEngine());
        trueEngines.add(new DecisionEngine());

        request= new LoanRequest(1,"food",20,p);
        app= new LoanApp(trueEngines,request);
        app.generateResponses();

        assertEquals("generateResponses should add 3 responses to the response list in the LoanApp object", 3, app.getResponses().size());

        DecisionEngine false1= new DecisionEngine();
        DecisionEngine false2 = new DecisionEngine();
        DecisionEngine true1 = new DecisionEngine();
        DecisionEngine true2= new DecisionEngine();

        falseEngines.add(false1);
        falseEngines.add(false2);
        falseEngines.add(true1);
        falseEngines.add(true2);

        app= new LoanApp(falseEngines, request);
        app.generateResponses();
        assertEquals("generateResponses should only add 2 responses to response List because" +
                " engine has 2 fasle approvals", 2, app.getResponses().size());
    }
}
