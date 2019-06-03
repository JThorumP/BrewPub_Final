//Lavet af - JTP
package com.example.demo.Service;

import com.example.demo.Model.Address;
import com.example.demo.Model.Employee_Address;
import com.example.demo.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til AddressRepo
@Service
public class AddressService implements InterService<Address> {
    //Her bliver der automatisk skabt en forbindelse til AddressRepo
    @Autowired
    AddressRepo addressRepo;

    //Sender videre til en metode i AddressRepo med samme navn
    @Override
    public List<Address> fetchAll() {
        return addressRepo.fetchAll();
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void addObject(Address address) {    }

    //Sender videre til en metode i AddressRepo med samme navn
    public void addObject(Employee_Address address) {
        addressRepo.addObject(address);
    }

    //Sender videre til en metode i AddressRepo med samme navn
    @Override
    public Boolean deleteById(int id) {
        return addressRepo.deleteById(id);
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void update(Address address) {    }

    //Sender videre til en metode i AddressRepo med samme navn
    public void update(Employee_Address emp_add) {
        addressRepo.update(emp_add);
    }

    //Sender videre til en metode i AddressRepo med samme navn
    @Override
    public Address fetchById(int id){
        return addressRepo.fetchById(id);
    }

}
