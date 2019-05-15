package com.javaeeeee.DAO;

import java.util.List;

import com.javaeeeee.api.Part;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.javaeeeee.groupMapper;
import com.javaeeeee.api.group_table;

@RegisterMapper(groupMapper.class)
public interface groupDao {

    @SqlQuery("select * from group_table;")
    public List<group_table> getGroups();

    @SqlUpdate("insert into group_table(group_name, group_id) values(:group_name, :group_id)")
    void createGroup(@BindBean final group_table group_tableObj);

    @SqlQuery("select * from group_table where group_id = :group_id")
    public group_table getGroup(@Bind("id") final String id);

    @SqlQuery("select last_insert_id();")
    public String lastInsertId();

//    @SqlUpdate("insert into parts(id,name, code) values(:id, :name, :code)")
//    void createPart(@BindBean final Part part);
//
//    @SqlUpdate("update parts set name = coalesce(:name, name), code = coalesce(:code, code) where id = :id")
//    void editPart(@BindBean final Part part);
//
//    @SqlUpdate("delete from parts where id = :id")
//    int deletePart(@Bind("id") final int id);
//
//    @SqlQuery("select last_insert_id();")
//    public int lastInsertId();
}

