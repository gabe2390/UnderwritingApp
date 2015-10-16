package io.zipcoder.undertakers.decisionenginebackend;

import org.junit.Test;

import java.sql.Array;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by rsparks on 10/15/15.
 */
public class PersonSpec {
    Job job = new Job("Developer", 99999999, "Sparks and friends", "Tech");
    Job job0 = new Job("Dishwasher", 9999, "Food and Stuffs", "Foodservice");
    Job[] jobArray = {job,job0};
    Asset asset = new Asset("Car", "Ole' faithful", 27000);
    Asset asset0 = new Asset("House", "Home", 127000);
    Asset[] assetArray = {asset, asset0};
    Person person = new Person("Rick", "Sparks", 26, "000-00-0000", true, jobArray,0, false, 1000,assetArray);
    Person person2 = new Person("Rick", "Sparks", 20, "000-00-0000", true, jobArray,0, false, 1000,assetArray);
    Person person3 = new Person("Rick", "Sparks", 44, "000-00-0000", true, jobArray,0, false, 1000,assetArray);

    @Test
    public void getAssetScoreSpec(){
        assertEquals("Should return score of assets",148,person.getAssetScore());
    }

    @Test
    public void getTotalIncomeSpec(){
        assertEquals("Should return total Income", 100009998, person.getTotalIncome());
    }

    @Test
    public void lookupCreditScoreSpec(){


        assertTrue("Should return a random integer between 400 and 800", 400<=person2.lookupCreditScore()&&person2.lookupCreditScore()<=800);
        assertTrue("Should return a random integer between 500 and 800", 400<=person.lookupCreditScore()&&person.lookupCreditScore()<=800);
        assertTrue("Should return a random integer between 650 and 800", 400<=person3.lookupCreditScore()&&person3.lookupCreditScore()<=800);
    }

}
