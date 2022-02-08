package org.launchcode.techjobs.oo.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import java.nio.charset.CoderResult;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)

public class JobTest {
    //    Test empty constructor. Empty constructor should create new IDs in sequential order.
    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertTrue(Math.abs((firstJob.getId() - secondJob.getId())) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Employer ACME = new Employer("ACME");
        Location Desert = new Location("Desert");
        PositionType QualityControl = new PositionType("Quality control");
        CoreCompetency Persistence = new CoreCompetency("Persistence");
        Job newJob = new Job("Product tester", ACME, Desert, QualityControl, Persistence);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(newJob.getPositionType() instanceof PositionType);
    }

    @Test
    public void testJobsForEquality(){
        Employer ACME = new Employer("ACME");
        Location Desert = new Location("Desert");
        PositionType QualityControl = new PositionType("Quality control");
        CoreCompetency Persistence = new CoreCompetency("Persistence");
        Job oldJob = new Job("Product tester", ACME, Desert, QualityControl, Persistence);
        Job newJob = new Job("Product tester", ACME, Desert, QualityControl, Persistence);
        assertFalse(newJob==oldJob);

    }
}