package com.example.demo.Repository;

import com.example.demo.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Denne klasse håndterer alt vores kommunikation til databasen angående Item
@Repository
public class ItemRepo implements InterRepo<Item>{
    //Her bliver der automatisk skabt en forbindelse til Jdbc
    @Autowired
    JdbcTemplate template;

    //Denne metode henter alle varer fra databasen
    @Override
    public List<Item> fetchAll(){
        String sql = "SELECT * FROM item";
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
        return template.query(sql,rowMapper);
    }

    //Denne metode går ind i databasen og henter 1 Item med det valgte ID
    @Override
    public Item fetchById(int id) {
        String sql = "SELECT * FROM item WHERE id=?" ;
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    //Denne metode tilføjer 1 objekt af en Item til databasen.
    @Override
    public void addObject(Item i) {
    String sql = "INSERT INTO item (item_name, category, amount) VALUES (?, ?, ?)";
        template.update(sql, i.getItem_name(), i.getCategory(), i.getAmount());
    }

    //Denne metode går ind i databasen og fjerner en Item med det valgte ID
    @Override
    public Boolean deleteById(int id) {
        String sql = "DELETE FROM item WHERE id=?";
        return template.update(sql, id) >0;
    }

    //Denne metode opdaterer 1 Item med de indtastede oplysninger ud fra tidligere valgte ID
    @Override
    public void update(Item i) {
        String sql = "UPDATE item SET item_name = ?, category = ?, amount = ? WHERE id=?";
        template.update(sql, i.getItem_name(), i.getCategory(), i.getAmount(), i.getId());
    }

    //Denne metode går ind i databasen og henter alle de forskellige kategorier der er
    public List<Item> category(){
        String sql = "SELECT DISTINCT category FROM item";
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
        List<Item> categoryList = template.query(sql, rowMapper);
        return categoryList;
    }

    //Denne metode går ind i databasen og henter alle varer indenfor den valgte kategori
    public List<Item> catChoice(String choice){
        String sql = "SELECT * FROM item WHERE category=?" ;
        RowMapper<Item> rowMapper = new BeanPropertyRowMapper<>(Item.class);
        return template.query(sql, rowMapper, choice);
    }
}
