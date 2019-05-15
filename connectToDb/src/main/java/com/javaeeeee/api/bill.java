package com.javaeeeee.api;

public class bill {
    private String bill_name;
    private String group_name;
    private float total=0f;

    public bill(){}

    public bill(String bill_name,String group_name, Float total)
    {
        this.bill_name=bill_name;
        this.group_name=group_name;
        this.total=total;

    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
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
