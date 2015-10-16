package io.zipcoder.undertakers.decisionenginebackend;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by gfurlong on 10/16/15.
 */
@RestController
@RequestMapping(value="/api")
public class DecisionEngineController {
    @RequestMapping(value="/engine")
    public DecisionEngine[] getEngines() {
        DecisionEngine[] engines = DecisionEngine.engines.toArray(new DecisionEngine[DecisionEngine.engines.size()]);
        return engines;
    }

    @RequestMapping(value="/engine", method = RequestMethod.PUT)
    public DecisionEngine createEngine(@RequestBody DecisionEngine engine) {
        DecisionEngine.engines.add(engine);
        engine.setId(DecisionEngine.nextId++);

        if(engine.getMaxAmount() < 30000) {
            // 3 years
            engine.setTerm(36);
        }
        else {
            // 3 to 30 years
            engine.setTerm(Math.min((engine.getMaxAmount() / 10000) * 12, 360));
        }

        return engine;
    }

    @RequestMapping(value="/engine", method = RequestMethod.PATCH)
    public DecisionEngine updateEngine(@RequestBody DecisionEngine updatedEngine) {
        DecisionEngine existingEngine = null;
        for(DecisionEngine e : DecisionEngine.engines) {
            if(e.getId() == updatedEngine.getId()) {
                existingEngine = e;
                break;
            }
        }

        if(existingEngine != null) {
            existingEngine.setMaxAmount(updatedEngine.getMaxAmount());

            existingEngine.setMaxDebt(updatedEngine.getMaxDebt());
            existingEngine.setMinAssetPoints(updatedEngine.getMinAssetPoints());
            existingEngine.setMinCredit(updatedEngine.getMinCredit());
            existingEngine.setMinIncome(updatedEngine.getMinIncome());
        }

        return existingEngine;
    }
}
