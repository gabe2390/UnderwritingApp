package io.zipcoder.undertakers.decisionenginebackend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel Humphrey on 10/16/15.
 * The app creates DecisionEngines, and sends loan request through them to generate LoanResponses
 */
public class LoanApp {
    private List<DecisionEngine> engines;
    private LoanRequest request;
    private List<LoanResponse> responses;

    /**
     * Constructor instantiates fields, then calls method to generate responses
     * @param engines List of Decision engines
     * @param request Request received from client side app
     */
    public LoanApp(List<DecisionEngine> engines, LoanRequest request) {
        this.engines = engines;
        this.request = request;
        responses = new ArrayList<>();
    }

    /**
     * Sends request through all available Decision Engines and add generated responses to responses List
     * if necessary
     */
    public void generateResponses() {
        for (DecisionEngine engine : engines) {
            if (engine.isApproved()) {
                responses.add(engine.generateResponse(request));
            }
        }
    }

    /**
     * returns all generated loan responses -should this necessarily be here to convert to JSON like in th e UML?
     * Spring does all of that for us with controllers - Tariq's demo yesterday
     */
    public List<LoanResponse> getResponses() {
        return responses;
    }
}
