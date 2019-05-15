package com.javaeeeee.DAO;

import com.javaeeeee.api.bill;
import com.javaeeeee.billMapper;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;

@RegisterMapper(billMapper.class)
public interface billDao {

    @SqlQuery("select * from bill;")
    public List<bill> getBill();

    @SqlUpdate("insert into bill(bill_name,group_name,total) values(:bill_name, :group_name, :total)")
    void createBill(@BindBean final bill billObj);

    @SqlQuery("select * from bill where bill_name = :bill_name")
    public bill getBill(@Bind("bill_name") final String bill_name);

    @SqlQuery("select group_name from bill where bill_name = :bill_name")
    public String getGroupName(@Bind("bill_name") final String bill_name);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();
}
