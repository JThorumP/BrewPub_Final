package com.example.demo.Service;

import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til EmployeeRepo
@Service
public class ItemService implements InterService<Item> {
    //Her bliver der automatisk skabt en forbindelse til ItemRepo
    @Autowired
    ItemRepo itemRepo;

    //Sender videre til en metode i ItemRepo med samme navn
    @Override
    public List<Item> fetchAll(){
        return itemRepo.fetchAll();
    }

    //Sender videre til en metode i ItemRepo med samme navn
    @Override
    public Item fetchById(int id) {
        return itemRepo.fetchById(id);
    }

    //Sender videre til en metode i ItemRepo med samme navn
    @Override
    public void addObject(Item i) {
        itemRepo.addObject(i);
    }

    //Sender videre til en metode i ItemRepo med samme navn
    @Override
    public Boolean deleteById(int id) {
        return itemRepo.deleteById(id);
    }

    //Sender videre til en metode i ItemRepo med samme navn
    @Override
    public void update(Item i) {
        itemRepo.update(i);
    }

    //Sender videre til en metode i ItemRepo med samme navn
    public List<Item> category(){ return itemRepo.category(); }

    //Sender videre til en metode i ItemRepo med samme navn
    public List<Item> catChoice( String choice) { return itemRepo.catChoice(choice); }
}
