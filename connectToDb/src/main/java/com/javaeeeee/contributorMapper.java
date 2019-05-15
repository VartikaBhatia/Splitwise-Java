package com.javaeeeee;

import com.javaeeeee.api.contributor;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class contributorMapper implements ResultSetMapper<contributor>{

    private static final String CONTRIBUTOR_NAME = "contributor_name";
    private static final String BILL_NAME = "bill_name";
    private static final String EXPENSE = "expense";
    private static final String PAID = "paid";




public contributor map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        return new contributor(resultSet.getString(CONTRIBUTOR_NAME),resultSet.getString(BILL_NAME), resultSet.getFloat(EXPENSE),resultSet.getFloat(PAID));
    }
}
