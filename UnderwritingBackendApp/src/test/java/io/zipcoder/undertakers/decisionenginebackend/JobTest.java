package io.zipcoder.undertakers.decisionenginebackend;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by rsparks on 10/15/15.
 */
public class JobTest {

    Job job = new Job("Dev", 1000000, "Sparks inc.", "Computer Science");

    @Test
    public void testGetPosition(){
        assertTrue("Checks what position is an instance of, which should be String",job.getPosition() instanceof String);
    }


    @Test
    public void testGetIncome(){
        assertTrue("Checks that income was set in the constructor",job.getIncome() == 1000000);
    }

    @Test
    public void testGetCompany(){
        assertTrue("Checks what company is an instance of, which should be String",job.getCompany() instanceof String);
    }

    @Test
    public void testGetType(){
        assertTrue("Checks what type is an instance of, which should be String",job.getType() instanceof String);
    }

}
