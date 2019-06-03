//Lavet af - AHH
package com.example.demo.Repository;

import com.example.demo.Model.Address;
import com.example.demo.Model.Employee;
import com.example.demo.Model.Employee_Address;
import com.example.demo.Model.LeaderLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til databasen angående Employee
@Repository
public class EmployeeRepo implements InterRepo<Employee>{
    //Her bliver der automatisk skabt en forbindelse til Jdbc
    @Autowired
    JdbcTemplate template;

    //Denne metode henter alle Employee fra databasen
    @Override
    public List<Employee> fetchAll(){
        String sql = "SELECT * FROM employee LIMIT 1, 100";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql,rowMapper);
    }

    //Denne metode går ind i databasen og henter 1 Employee med det valgte ID
    @Override
    public Employee fetchById(int id){
        String sql = "SELECT * FROM employee WHERE id=?" ;
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    //Da der skal bruges 1 objekt fyldt med Employee og Address information, så bruger vi ikke denne metode
    @Override
    public void addObject(Employee employee) {    }

    /*
    Denne metode modtager et objekt fra kombinationsklassen og tilføjer til employee databasen
    med de indtastede oplysninger fra addEmployee.html.
    */
    public void addObject(Employee_Address employee) {
        String sql = "INSERT INTO employee (first_name, last_name, phone_number, fk_address_id) VALUES (?, ?, ?, ?)";
        String sqlAddressId = "SELECT * FROM address ORDER BY id desc LIMIT 1";
        RowMapper<Address> rowMapper = new BeanPropertyRowMapper<>(Address.class);
        List<Address> tempAddressId = template.query(sqlAddressId, rowMapper);
        int addressId = tempAddressId.get(0).getId();
        template.update(sql, employee.getFirst_name(), employee.getLast_name(), employee.getPhone_number(), addressId);
    }

    //Denne metode går ind i databasen og fjerner en Employee med det valgte ID
    @Override
    public Boolean deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return template.update(sql,id)>0;
    }

    //Da der skal bruges 1 objekt fyldt med Employee og Address info, så bruger vi ikke denne metode
    @Override
    public void update(Employee employee) {    }

    //Denne metode opdaterer 1 Employee med de indtastede oplysninger ud fra tidligere valgte ID
    public void update(Employee_Address employee) {
        String sql = "UPDATE employee SET first_name = ?, last_name = ?, phone_number = ? WHERE id=?";
        template.update(sql, employee.getFirst_name(), employee.getLast_name(), employee.getPhone_number(), employee.getId());
    }

    //Denne metode henter ID 1 fra employee-databasen og sammenligner med det indtastede ID og password
    public Boolean fetchLeader(LeaderLogin leaderTest){
        String sql = "SELECT * FROM employee LIMIT 1";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee leader = template.queryForObject(sql, rowMapper);
        boolean leaderResult = leader.getId() == leaderTest.getId() && leader.getPassword().equals(leaderTest.getPassword());
        return leaderResult;
    }

    //Denne metode skaber en liste med alt information om hver enkelt ansat
    public List<Employee_Address> fullInfo(){
        String sql = "SELECT * FROM employee LEFT JOIN address ON employee.fk_address_id = address.id LIMIT 1,100";
        RowMapper<Employee_Address> rowMapper = new BeanPropertyRowMapper<>(Employee_Address.class);
        return template.query(sql, rowMapper);
    }
}

