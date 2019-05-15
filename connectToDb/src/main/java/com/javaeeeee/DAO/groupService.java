package com.javaeeeee.DAO;

import com.javaeeeee.api.group_table;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class groupService {
    @CreateSqlObject
    abstract groupDao groupDaoObj();


    public List<group_table> getGroups() {
        return groupDaoObj().getGroups();
    }

    public group_table getGroup(String  id) {
        group_table group_tableObj = groupDaoObj().getGroup(id);
        return group_tableObj;
    }

    public group_table createGroup(group_table group_tableObj) {
        groupDaoObj().createGroup(group_tableObj);

        return groupDaoObj().getGroup(groupDaoObj().lastInsertId());
    }
}
