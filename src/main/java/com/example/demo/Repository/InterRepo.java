package com.example.demo.Repository;

import java.util.List;

//Interfacet er for bedre struktur
public interface InterRepo<T> {

    //Skal hente alle fra en tabel
    List<T> fetchAll();

    //Skal hente 1 objekt med valgte id
    T fetchById(int id);

    //Skal tilføje 1 objekt til databasen af valgte
    void addObject(T t);

    //Skal fjerne 1 objekt fra databasen med valgte id.
    Boolean deleteById(int id);

    //Skal opdatere databasen med det valgte objekt.
    void update(T t);

}
