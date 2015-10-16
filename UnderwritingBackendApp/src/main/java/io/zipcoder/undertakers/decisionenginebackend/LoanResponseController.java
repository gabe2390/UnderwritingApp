package io.zipcoder.undertakers.decisionenginebackend;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghumphrey on 10/16/15.
 */
@RestController
public class LoanResponseController {
    LoanResponse[] loanResponseArrayList;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public LoanResponse[] sendResponse(@RequestBody LoanRequest loanRequest){
        System.out.println(loanRequest);
        LoanApp loanApp = new LoanApp(loanRequest);
        loanApp.generateResponses();
        List<LoanResponse> responseList = loanApp.getResponses();
        return responseList.toArray(new LoanResponse[responseList.size()]);

    }
}
