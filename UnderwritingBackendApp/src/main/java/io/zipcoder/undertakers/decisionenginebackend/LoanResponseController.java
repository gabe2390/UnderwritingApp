package io.zipcoder.undertakers.decisionenginebackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by ghumphrey on 10/16/15.
 */
@RestController
public class LoanResponseController {
    ArrayList<LoanResponse> loanResponseArrayList;
    LoanResponse loanResponse = new LoanResponse(true, 2000, 204, 48);
    LoanResponse loanResponse1 = new LoanResponse(true, 40000, 200, 36);

    @RequestMapping("/new")
    public ArrayList sendResponse(){
        loanResponseArrayList = new ArrayList<>();
        loanResponseArrayList.add(loanResponse);
        loanResponseArrayList.add(loanResponse1);
        return loanResponseArrayList;
    }
}
