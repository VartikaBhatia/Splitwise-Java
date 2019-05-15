package com.javaeeeee;

import com.javaeeeee.api.group_table;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class groupMapper implements ResultSetMapper<group_table> {

    private static final String GROUP_ID = "group_id";
    private static final String GROUP_NAME = "group_name";


    public group_table map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        return new group_table(resultSet.getString(GROUP_NAME), resultSet.getString(GROUP_ID));
    }
}
