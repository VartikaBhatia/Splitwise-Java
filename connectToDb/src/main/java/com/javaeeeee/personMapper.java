package com.javaeeeee;

import com.javaeeeee.api.person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class personMapper implements ResultSetMapper<person> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TOTAL="total";
    private static final String AGE="age";

    public person map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        return new person(resultSet.getInt(ID), resultSet.getString(NAME), resultSet.getFloat(TOTAL),resultSet.getInt(AGE));
    }
}
