package com.javaeeeee;

import com.javaeeeee.api.bill;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class billMapper implements ResultSetMapper<bill> {
    private static final String BILL_NAME = "bill_name";
    private static final String GROUP_NAME = "group_name";
    private static final String TOTAL="total";


    public bill map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        return new bill(resultSet.getString(BILL_NAME), resultSet.getString(GROUP_NAME), resultSet.getFloat(TOTAL));
    }
}
