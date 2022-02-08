package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)

public class JobTest {
//   objective 4 testing constructor
    //    Test empty constructor. Empty constructor should create new IDs in sequential order.
    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertFalse(firstJob.getId()==secondJob.getId());
    }
// test that constructor sets all fields and checks instance of field
    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(newJob.getName(),"Product tester");
        assertTrue(newJob.getName() instanceof String);

        assertTrue(newJob.getEmployer() instanceof Employer);
        assertEquals(newJob.getEmployer().getValue(), "ACME");

        assertTrue(newJob.getLocation() instanceof Location);
        assertEquals(newJob.getLocation().getValue(), "Desert");

        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertEquals(newJob.getPositionType().getValue(), "Quality control" );

        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");



    }
//  Test that identical Job objects have  unique id.
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
//    objective five build string using TDD.
}