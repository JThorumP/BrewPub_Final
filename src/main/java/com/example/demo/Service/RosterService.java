//Lavet af - JLP
package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Roster;
import com.example.demo.Model.Roster_Employee;
import com.example.demo.Repository.RosterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til RosterRepo
@Service
public class RosterService implements InterService<Roster>{
    //Her bliver der automatisk skabt en forbindelse til RosterRepo
    @Autowired
    RosterRepo rosterRepo;

    //Sender videre til en metode i RosterRepo med samme navn
    @Override
    public List<Roster> fetchAll(){
        return rosterRepo.fetchAll();
    }

    //Sender videre til en metode i RosterRepo med samme navn
    public List<Roster_Employee> fetchFullList(){return rosterRepo.fetchFullList(); }

    //Implementerert fra Interfacet, men bruges ikke
    @Override
    public void addObject(Roster roster) {    }

    //Sender videre til en metode i RosterRepo med samme navn
    public void addObject() { rosterRepo.addObject();}

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void update(Roster roster) {   }

    //Sender videre til en metode i RosterRepo med samme navn
    public void update (int id, Roster roster){ rosterRepo.update(id, roster);}

    //Sender videre til en metode i RosterRepo med samme navn
    @Override
    public Roster fetchById(int id) {
        return rosterRepo.fetchById(id);
    }

    //Sender videre til en metode i RosterRepo med samme navn
    @Override
    public Boolean deleteById(int id) {
        return rosterRepo.deleteById(id);
    }
}
