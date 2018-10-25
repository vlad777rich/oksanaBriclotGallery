package com.oksana.dao;

import com.oksana.entities.Tail;
import com.oksana.mappers.TailMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TailDao {
    private JdbcTemplate jdbcTemplate;

    public TailDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcTemplate.execute(
                "create schema if not exists FOTOGALLERY;\n" +
                "create table if not exists FOTOGALLERY.FOTOSTORAGE(" +
                        "DESCRIPTIONDE varchar(1024),\n"+
                        "DESCRIPTIONEN varchar(1024),\n"+
                        "DATEOFCREATION varchar(1024),\n"+
                        "TAILNAME varchar(1024),\n"+
                        "PATHTOFILE varchar(2048),\n"+
                        "TYPE varchar(1024));\n");
    }

    public List<Tail> getAllTails() {
        String sql = "SELECT * FROM TEST.FOTOGALLERY.FOTOSTORAGE";

        return jdbcTemplate.query(sql, new TailMapper());
    }

    public void addTail(Tail tail) {
        String sql = "INSERT INTO FOTOGALLERY.FOTOSTORAGE (DESCRIPTIONDE, DESCRIPTIONEN, DATEOFCREATION, TAILNAME, PATHTOFILE, TYPE)" +
                " VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, tail.getDescriptionDe(), tail.getDescriptionEn(),
                tail.getDateOfCreation(), tail.getName(), tail.getPathToFile(), tail.getType());
    }

    public void deleteTailByName(String name) {
        String sql = "DELETE FROM FOTOGALLERY.FOTOSTORAGE WHERE TAILNAME = ?";
        jdbcTemplate.update(sql, name);
    }

    public List<Tail> getAllProductsByType(String type) {
        String sql = "SELECT * FROM FOTOGALLERY.FOTOSTORAGE WHERE TYPE = ?";
        return jdbcTemplate.query(sql, new TailMapper(), type);
    }

    public Tail getTailByName(String name) {
        String sql = "SELECT * FROM FOTOGALLERY.FOTOSTORAGE WHERE TAILNAME = ?";
        List<Tail> tails = jdbcTemplate.query(sql, new TailMapper(), name);
        return tails.get(0);
    }
    public void deleteAllTails() {
        String sql = "DELETE * FROM FOTOGALLERY.FOTOSTORAGE";
        jdbcTemplate.update(sql);
    }
}