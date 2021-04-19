package com.example.assignment9;

public class User {
    public String name;
    public String nurseName;
    public String vaccine1Date;
    public String vaccine2Date;
    public String locationAdministered;
    public boolean fullyVaccinated;


    public User(String name, String nurseName, String vaccine1Date, String vaccine2Date, String locationAdministered, boolean fullyVaccinated){
        this.name = name;
        this.nurseName = nurseName;
        this.vaccine1Date = vaccine1Date;
        this.vaccine2Date = vaccine2Date;
        this.locationAdministered = locationAdministered;
        this.fullyVaccinated = fullyVaccinated;
    }
}
