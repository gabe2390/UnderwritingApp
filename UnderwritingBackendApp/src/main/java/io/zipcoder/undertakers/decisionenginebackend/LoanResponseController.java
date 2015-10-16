package io.zipcoder.undertakers.decisionenginebackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ghumphrey on 10/16/15.
 */
@RestController
public class LoanResponseController {
    @RequestMapping("/new")
    public LoanResponse sendResponse(@RequestParam(value="approved",defaultValue = "false")boolean approved,
                                     @RequestParam(value= "maxLoan", defaultValue = "50000")int maxLoan,
                                     @RequestParam(value= "monthlyPayment", defaultValue = "36")int monthlyPayment,
                                     @RequestParam(value= "repaymentTerm", defaultValue = "50000")int repaymentTerm){

        return new LoanResponse(approved,maxLoan,monthlyPayment,repaymentTerm);
    }
}
