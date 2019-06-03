//Lavet af - JLP
package com.example.demo.Model;

//Denne klasse er en kombinationsklasse til at håndtere Employee og Address
public class Employee_Address {
    //Dette er den samlede liste af fields der skal bruges
    private int id;
    private String first_name;
    private String last_name;
    private int phone_number;
    private int salery;
    private int address_id;
    private int zip_code;
    private String city_name;
    private String road;
    private int house_number;

    /*
    Vi bruger 2 konstruktører
    Den tomme konstruktør er obligatorisk da man overskriver den efter at have oprettet
    en konstruktør med 1 eller flere parametre
    */
    public Employee_Address() {
    }
    public Employee_Address(int id, String first_name, String last_name, int phone_number, int address_id, int zip_code, String city_name, String road, int house_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address_id = address_id;
        this.zip_code = zip_code;
        this.city_name = city_name;
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

    public int getSalery() {
        return salery;
    }

    public void setSalery(int salery) {
        this.salery = salery;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
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
