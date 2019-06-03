//Lavet af -AHH
package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Denne klasse er svarer til item-tabellen i databasen
@Entity
public class Item {
    //Dette er de fields vi bruger til at udfylde kolonnerne i databasen
    @Id
    private int id;
    private String item_name;
    private String category;
    private int amount;

    /*
    Vi bruger 2 konstruktører
    Den tomme konstruktør er obligatorisk da man overskriver den efter at have oprettet
    en konstruktør med 1 eller flere parametre
    */
    public Item() {
    }
    public Item(int id, String item_name, String category, int amount) {
        this.id = id;
        this.item_name = item_name;
        this.category = category;
        this.amount = amount;
    }

    //Sektionen nedenunder er vores Getters og Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
