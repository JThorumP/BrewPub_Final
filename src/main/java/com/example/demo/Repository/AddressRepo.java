//Lavet af - JTP
package com.example.demo.Repository;

import com.example.demo.Model.Address;
import com.example.demo.Model.Employee_Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til databasen angående Address
@Repository
public class AddressRepo implements InterRepo<Address>{
    //Her bliver der automatisk skabt en forbindelse til Jdbc
    @Autowired
    JdbcTemplate template;

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public List<Address> fetchAll(){ return null; }

    //Denne metode går ind i databasen og henter 1 Address med det valgte ID
    @Override
    public Address fetchById(int id){
        String sql = "SELECT * FROM address WHERE id=?" ;
        RowMapper<Address> rowMapper = new BeanPropertyRowMapper<>(Address.class);
        Address a = template.queryForObject(sql, rowMapper, id);
        return a;
    }

    //Da der skal bruges 1 objekt fyldt med Employee og Address information, så bruger vi ikke denne metode
    @Override
    public void addObject(Address address) {    }

    /*
    Denne metode modtager et objekt fra kombinationsklassen og tilføjer til address databasen
    med de indtastede oplysninger fra addEmployee.html
    */
    public void addObject(Employee_Address address){
        String sql = "INSERT INTO address (zip_code, city_name, road, house_number) VALUES (?, ?, ?, ?)";
        template.update(sql, address.getZip_code(), address.getCity_name(), address.getRoad(), address.getHouse_number());
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void update(Address address) {    }

    //Denne metode opdaterer 1 Address med de indtastede oplysninger ud fra tidligere valgte ID
    public void update(Employee_Address emp_add){
        String sql = "UPDATE address SET zip_code = ?, city_name = ?, road = ?, house_number = ? WHERE id=?";
        template.update(sql, emp_add.getZip_code(), emp_add.getCity_name(), emp_add.getRoad(), emp_add.getHouse_number(), emp_add.getAddress_id());
    }

    //Denne metode går ind i databasen og fjerner en Address med det valgte ID
    @Override
    public Boolean deleteById(int id){
        String sql = "DELETE FROM address WHERE id=?";
        return template.update(sql,id) > 0;
    }

}
