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
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char char0= newJob.toString().charAt(0);
        char charLast=newJob.toString().charAt(newJob.toString().length()-1);
        assertEquals(char0,'\n');
        assertEquals(charLast, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.toString(), '\n'+
                "ID: " + newJob.getId() + '\n'+
                "Name: " + "Product tester" + '\n'+
                "Employer: " + "ACME" + '\n'+
                "Location: " + "Desert" + '\n'+
                "Position Type: " + "Quality control" + '\n'+
                "Core Competency: " + "Persistence" + '\n'
                ) ;

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job notAJob= new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        Job newJob = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
//       vars borrowed from main method
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency(""));
        Job job3 = new Job("Ice cream tester", new Employer("Oz Corp"), new Location("Home"), new PositionType(""), new CoreCompetency(""));


        assertEquals(newJob.toString(), '\n'+
                "ID: " + newJob.getId() + '\n'+
                "Name: " + "Product tester" + '\n'+
                "Employer: " + "Data not available" + '\n'+
                "Location: " + "Desert" + '\n'+
                "Position Type: " + "Quality control" + '\n'+
                "Core Competency: " + "Persistence" + '\n') ;

        assertEquals(job2.toString(), '\n'+
                "ID: " + job2.getId() + '\n'+
                "Name: " + "Web Developer" + '\n'+
                "Employer: " + "LaunchCode" + '\n'+
                "Location: " + "St. Louis" + '\n'+
                "Position Type: " + "Front-end developer" + '\n'+
                "Core Competency: " + "Data not available" + '\n'
                ) ;

        assertEquals(job3.toString(), '\n'+
                "ID: " + job3.getId() + '\n'+
                "Name: " + "Ice cream tester" + '\n'+
                "Employer: " + "Oz Corp" + '\n'+
                "Location: " + "Home" + '\n'+
                "Position Type: " + "Data not available" + '\n'+
                "Core Competency: " + "Data not available" + '\n') ;
//        assertEquals(notAJob, "OOPS! This job does not seem to exist.");

    }







}
