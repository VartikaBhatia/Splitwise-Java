package com.javaeeeee.DAO;

import com.javaeeeee.api.member;
import com.javaeeeee.api.person;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.javaeeeee.memberMapper;
import java.util.List;

@RegisterMapper(memberMapper.class)

public interface memberDao {

    @SqlQuery("select * from member;")
    public List<member> getMembers();

    @SqlQuery("select * from member where mem_name = :mem_name")
    public List<member> getMember(@Bind("mem_name") final String mem_name);

    @SqlUpdate("insert into member(mem_name,group_name,total) values(:mem_name, :group_name, :total)")
    void createMember(@BindBean final member memberObj);

    @SqlQuery("select * from member where mem_name= :mem_name and group_name= :group_name")
    public member getMemberObj( @Bind("mem_name") final String mem_name, @Bind("group_name") final String group_name);

    @SqlQuery("select total from member where mem_name= :mem_name and group_name= :group_name")
    public Float getTotal( @Bind("mem_name") final String mem_name, @Bind("group_name") final String group_name);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();

    @SqlUpdate("update member set total = coalesce(:total, total) where group_name = :group_name and mem_name= :mem_name ")
    void updateMember(@BindBean final member memberObj);
}
