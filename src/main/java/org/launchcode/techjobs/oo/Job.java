package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job<employer> {
    private String noData="Data not available";

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.


    public Job(){
        id = nextId;
        nextId++;
    }

//    public Job(int id) {
//        this();
//        this.id = id;
//    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }



    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.




    @Override
    public String toString() {

        String nameTag= this.getName();
        String employerTag= this.getEmployer().getValue();
        String locationTag= this.getLocation().getValue();
        String positionTag= this.getPositionType().getValue();
        String coreCompTag= this.getCoreCompetency().getValue();


        if(nameTag==""){
            nameTag=noData;
        }
        if(employerTag==""){
             employerTag=noData;
        }
        if(locationTag==""){
            locationTag=noData;
        }
        if(positionTag==""){
            positionTag=noData;
        }
        if(coreCompTag==""){
            coreCompTag=noData;
        }

        String jobReport="\n"+
                "ID: " + id + "\n"+
                "Name: " + nameTag  +"\n"+
                "Employer: " + employerTag + "\n"+
                "Location: " + locationTag + "\n"+
                "Position Type: " + positionTag + "\n"+
                "Core Competency: " + coreCompTag + "\n";

        if(employerTag==noData&& locationTag==noData&& positionTag==noData
        && coreCompTag==noData){
            jobReport="OOPS! This job does not seem to exist.";
        }

        return jobReport;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
