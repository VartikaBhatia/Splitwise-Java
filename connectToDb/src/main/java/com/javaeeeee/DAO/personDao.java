package com.javaeeeee.DAO;

import java.util.List;

import com.javaeeeee.api.Part;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.javaeeeee.personMapper;
import com.javaeeeee.api.person;

@RegisterMapper(personMapper.class)
public interface personDao {

    @SqlQuery("select * from person;")
    public List<person> getPersons();

    @SqlUpdate("insert into person(age, name, total, id) values(:age, :name, :total, :id)")
    void createPerson(@BindBean final person personObj);

    @SqlQuery("select * from person where id = :id")
    public person getPerson(@Bind("id") final int id);

    @SqlQuery("select total from person where name = :name")
    public Float getTotal(@Bind("name") final String name);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();

    @SqlQuery("select * from person where name = :name")
    public person getPersonByName(@Bind("name") final String name);
//    @SqlUpdate("insert into parts(id,name, code) values(:id, :name, :code)")
//    void createPart(@BindBean final Part part);
//
    @SqlUpdate("update person set total = coalesce(:total, total) where name = :name")
    void updatePerson(@BindBean final person personObj);
//
//    @SqlUpdate("delete from parts where id = :id")
//    int deletePart(@Bind("id") final int id);
//
//    @SqlQuery("select last_insert_id();")
//    public int lastInsertId();
}
