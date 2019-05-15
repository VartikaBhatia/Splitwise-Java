package com.javaeeeee;

import com.javaeeeee.api.member;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class memberMapper implements ResultSetMapper<member> {

        private static final String MEM_NAME = "mem_name";
        private static final String GROUP_NAME = "group_name";
        private static final String TOTAL="total";


        public member map(int i, ResultSet resultSet, StatementContext statementContext)
                throws SQLException {
            return new member(resultSet.getString(MEM_NAME), resultSet.getString(GROUP_NAME), resultSet.getFloat(TOTAL));
        }
    }

