// Lavet af - AHH
package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Denne klasse er svarer til addresse-tabellen i databasen
@Entity
public class Address {
    //Dette er de fields som bruges til at udfylde kolonnerne i databasen
    @Id
    private int id;
    private String city_name;
    private int zip_code;
    private String road;
    private int house_number;

    /*
        Vi bruger 2 konstruktører
        Den tomme konstruktør er obligatorisk da man overskriver den efter at have oprettet
        en konstruktør med 1 eller flere parametre
    */
    public Address() {

    }
    public Address(int id, String city_name, int zip_code, String road, int house_number){
    this.id = id;
    this.city_name = city_name;
    this.zip_code = zip_code;
    this.road = road;
    this.house_number = house_number;
    }

    //Sektionen nedenunder er vores Getters og Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }
}
