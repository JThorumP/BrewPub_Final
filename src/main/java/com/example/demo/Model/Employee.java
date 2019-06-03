//Lavet af - JTP
package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Denne klasse er svarer til employee-tabellen i databasen
@Entity
public class Employee {
    //Dette er de fields som bruges til at udfylde kolonnerne i databasen
    @Id
    private int id;
    private String first_name;
    private String last_name;
    private int phone_number;
    private int fk_address_id;
    private int salery;
    private String password;

    /*
    Vi bruger 2 konstruktører
    Den tomme konstruktør er obligatorisk da man overskriver den efter at have oprettet
    en konstruktør med 1 eller flere parametre
    */
    public Employee(){    }
    public Employee(int id, String first_name, String last_name, int phone_number, int fk_address_id, String password){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.fk_address_id = fk_address_id;
        this.password = password;
    }

    //Sektionen nedenunder er vores Getters og Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getFk_address_id() {
        return fk_address_id;
    }

    public void setFk_address_id(int fk_address_id) {
        this.fk_address_id = fk_address_id;
    }

    public int getSalery() {
        return salery;
    }

    public void setSalery(int salery) {
        this.salery = salery;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
