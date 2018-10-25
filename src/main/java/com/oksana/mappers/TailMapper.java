package com.oksana.mappers;



import com.oksana.entities.Tail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TailMapper implements RowMapper<Tail> {


    @Override
    public Tail mapRow(ResultSet resultSet, int i) throws SQLException {
        Tail tail = new Tail();
        tail.setName(resultSet.getString("tailname"));
        tail.setDescriptionDe(resultSet.getString("descriptionde"));
        tail.setDescriptionEn(resultSet.getString("descriptionen"));
        tail.setDateOfCreation(resultSet.getString("dateofcreation"));
        tail.setPathToFile(resultSet.getString("pathtofile"));
        tail.setType(resultSet.getString("type"));

        return tail;
    }
}
