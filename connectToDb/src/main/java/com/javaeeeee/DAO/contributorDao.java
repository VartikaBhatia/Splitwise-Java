package com.javaeeeee.DAO;

import com.javaeeeee.api.contributor;
import com.javaeeeee.contributorMapper;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(contributorMapper.class)

public interface contributorDao {

    @SqlQuery("select * from contributor;")
    public List<contributor> getContributors();

    @SqlUpdate("insert into contributor(contributor_name,bill_name,expense,paid) values(:contributor_name, :bill_name, :expense, :paid)")
    void createContributors(@BindBean final contributor contributorObj);

    @SqlQuery("select * from contributor where bill_name = :bill_name")
    public List<contributor> getContributors(@Bind("bill_name") final String bill_name);

//    @SqlQuery("select last_insert_id();")
//    public int lastInsertId();
}
