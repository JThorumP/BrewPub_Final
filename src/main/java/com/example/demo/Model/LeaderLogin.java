package com.example.demo.Model;

//Denne klasse skaber et midlertidigt objekt som sættes op mod indtastede ID og password
public class LeaderLogin {
    //Dette er de fields der testes på
    private int id;
    private String password;

    //Dette er vores Getters og Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
