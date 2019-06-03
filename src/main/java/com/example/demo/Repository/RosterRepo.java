package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Roster;
import com.example.demo.Model.Roster_Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til databasen angående Roster
@Repository
public class RosterRepo implements InterRepo<Roster>{
    //Her bliver der automatisk skabt en forbindelse til Jdbc
    @Autowired
    JdbcTemplate template;

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public List<Roster> fetchAll() {
        return null;
    }

    //Denne metode laver en liste med en kombination af Roster og Employee(first_name)
    public List<Roster_Employee> fetchFullList(){
        String sql = "SELECT employee.id, employee.first_name, roster.id, roster.monday_clock, roster.tuesday_clock, roster.wednesday_clock, roster.thursday_clock" +
                ", roster.friday_clock, roster.saturday_clock, roster.sunday_clock FROM employee JOIN roster ON roster.fk_employee_id = employee.id LIMIT 1,100";
        RowMapper<Roster_Employee> rowMapper = new BeanPropertyRowMapper<>(Roster_Employee.class);
        return template.query(sql, rowMapper);
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void addObject(Roster roster) {    }

    //Denne metode opretter en ny række i roster-tabellen med forbindelse til sidst tilføjede Employee
    public void addObject() {
        String sql = "INSERT INTO roster (fk_employee_id) VALUES (?)";
        String sqlEmployeeId = "SELECT * FROM employee ORDER BY id desc LIMIT 1";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> tempEmployeeId = template.query(sqlEmployeeId, rowMapper);
        int employeeId = tempEmployeeId.get(0).getId();
        template.update(sql, employeeId);
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public void update(Roster roster) {    }

    //Denne metode bruger et id og nyt objekt af Roster for at ændre i roster-tabellen
    public void update(int id, Roster roster) {
        String controlSQL = "SELECT * FROM roster WHERE id=?";
        RowMapper<Roster> rowMapper = new BeanPropertyRowMapper<>(Roster.class);
        Roster rosterObject = template.queryForObject(controlSQL, rowMapper, id);
        do {
            if (!rosterObject.getMonday_clock().equals(roster.getMonday_clock())) {
                String updateSQL = "UPDATE roster SET monday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getMonday_clock(), id);

            } else if (!rosterObject.getTuesday_clock().equals(roster.getTuesday_clock())) {
                String updateSQL = "UPDATE roster SET tuesday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getTuesday_clock(), id);

            } else if (!rosterObject.getWednesday_clock().equals(roster.getWednesday_clock())) {
                String updateSQL = "UPDATE roster SET wednesday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getWednesday_clock(), id);

            } else if (!rosterObject.getThursday_clock().equals(roster.getThursday_clock())) {
                String updateSQL = "UPDATE roster SET thursday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getThursday_clock(), id);

            } else if (!rosterObject.getFriday_clock().equals(roster.getFriday_clock())) {
                String updateSQL = "UPDATE roster SET friday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getFriday_clock(), id);

            } else if (!rosterObject.getSaturday_clock().equals(roster.getSaturday_clock())) {
                String updateSQL = "UPDATE roster SET saturday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getSaturday_clock(), id);

            } else if (!rosterObject.getSunday_clock().equals(roster.getSunday_clock())) {
                String updateSQL = "UPDATE roster SET Sunday_clock = ? WHERE id=?";
                template.update(updateSQL, roster.getSunday_clock(), id);
            }

            controlSQL = "SELECT * FROM roster WHERE id=?";
            rowMapper = new BeanPropertyRowMapper<>(Roster.class);
            rosterObject = template.queryForObject(controlSQL, rowMapper, id);
        }while (!rosterObject.equals(roster));
    }

    //Implementeret fra Interfacet, men bruges ikke
    @Override
    public Roster fetchById(int id) {
        return null;
    }

    //Denne metode går ind i databasen og fjerner en Roster med det valgte ID
    @Override
    public Boolean deleteById(int id) {
        String sql = "DELETE FROM roster WHERE id=?";
        return template.update(sql, id)>0;
    }
}
