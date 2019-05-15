package com.javaeeeee.api;

import java.util.List;

public class group_table {

    private String group_name;
    private String group_id;


    public group_table(){}

    public group_table( String group_name,String group_id)
    {
        this.group_id=group_id;
        this.group_name=group_name;

    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }


}
