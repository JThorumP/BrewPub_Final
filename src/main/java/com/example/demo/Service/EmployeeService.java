package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Employee_Address;
import com.example.demo.Model.LeaderLogin;
import com.example.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til EmployeeRepo
@Service
public class EmployeeService implements InterService<Employee> {
    //Her bliver der automatisk skabt en forbindelse til EmployeeRepo
    @Autowired
    EmployeeRepo employeeRepo;

    //Sender videre til en metode i EmployeeRepo med samme navn
    public Boolean fetchLeader(LeaderLogin leaderTest){
        return employeeRepo.fetchLeader(leaderTest);
    }

    //Sender videre til en metode i EmployeeRepo med samme navn
    @Override
    public List<Employee> fetchAll(){
        return employeeRepo.fetchAll();
    }

    //Sender videre til en metode i EmployeeRepo med samme navn
    @Override
    public Employee fetchById(int id){
        return employeeRepo.fetchById(id);
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void addObject(Employee employee) {    }

    //Sender videre til en metode i EmployeeRepo med samme navn
    public void addObject(Employee_Address employee) { employeeRepo.addObject(employee);    }

    //Sender videre til en metode i EmployeeRepo med samme navn
    @Override
    public Boolean deleteById(int id) {
        return employeeRepo.deleteById(id);
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void update(Employee employee) {    }

    //Sender videre til en metode i EmployeeRepo med samme navn
    public void update(Employee_Address emp_add) {
        employeeRepo.update(emp_add);
    }

    //Sender videre til en metode i EmployeeRepo med samme navn
    public List<Employee_Address> fullList(){
        return employeeRepo.fullInfo();
    }
}
