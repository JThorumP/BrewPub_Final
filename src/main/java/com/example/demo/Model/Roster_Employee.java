package com.example.demo.Model;

//Denne klasse er en kombinationsklasse til at håndtere Roster og Employee
public class Roster_Employee {
    //Dette er den samlede liste af fields der skal bruges
    private int id;
    private String monday_clock;
    private String tuesday_clock;
    private String wednesday_clock;
    private String thursday_clock;
    private String friday_clock;
    private String saturday_clock;
    private String sunday_clock;
    private int fk_employee_id;
    private String first_name;

    /*
    Vi bruger 2 konstruktører
    Den tomme konstruktør er obligatorisk da man overskriver den efter at have oprettet
    en konstruktør med 1 eller flere parametre
    */
    public Roster_Employee() {
    }
    public Roster_Employee(int id, String monday_clock, String tuesday_clock, String wednesday_clock, String thursday_clock, String friday_clock, String saturday_clock, String sunday_clock, int fk_employee_id, String first_name) {
        this.id = id;
        this.monday_clock = monday_clock;
        this.tuesday_clock = tuesday_clock;
        this.wednesday_clock = wednesday_clock;
        this.thursday_clock = thursday_clock;
        this.friday_clock = friday_clock;
        this.saturday_clock = saturday_clock;
        this.sunday_clock = sunday_clock;
        this.fk_employee_id = fk_employee_id;
        this.first_name = first_name;
    }

    //Dette er vores Getters og Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonday_clock() {
        return monday_clock;
    }

    public void setMonday_clock(String monday_clock) {
        this.monday_clock = monday_clock;
    }

    public String getTuesday_clock() {
        return tuesday_clock;
    }

    public void setTuesday_clock(String tuesday_clock) {
        this.tuesday_clock = tuesday_clock;
    }

    public String getWednesday_clock() {
        return wednesday_clock;
    }

    public void setWednesday_clock(String wednesday_clock) {
        this.wednesday_clock = wednesday_clock;
    }

    public String getThursday_clock() {
        return thursday_clock;
    }

    public void setThursday_clock(String thursday_clock) {
        this.thursday_clock = thursday_clock;
    }

    public String getFriday_clock() {
        return friday_clock;
    }

    public void setFriday_clock(String friday_clock) {
        this.friday_clock = friday_clock;
    }

    public String getSaturday_clock() {
        return saturday_clock;
    }

    public void setSaturday_clock(String saturday_clock) {
        this.saturday_clock = saturday_clock;
    }

    public String getSunday_clock() {
        return sunday_clock;
    }

    public void setSunday_clock(String sunday_clock) {
        this.sunday_clock = sunday_clock;
    }

    public int getFk_employee_id() {
        return fk_employee_id;
    }

    public void setFk_employee_id(int fk_employee_id) {
        this.fk_employee_id = fk_employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
