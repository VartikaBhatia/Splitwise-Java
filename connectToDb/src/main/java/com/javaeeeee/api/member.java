package com.javaeeeee.api;

public class member {
    private String mem_name;
    private String group_name;
    private float total=0f;

    public member(){}

    public member(String mem_name,String group_name, float total){
        this.mem_name=mem_name;
        this.group_name=group_name;
        this.total=total;

    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
