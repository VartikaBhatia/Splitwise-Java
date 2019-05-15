package com.javaeeeee.api;

public class contributor {

    private String contributor_name;
    private String bill_name;
    private Float expense;
    private Float paid;

    public contributor(){ }

    public contributor(String contributor_name,String bill_name, Float expense, Float paid)
    {
        this.bill_name=bill_name;
        this.contributor_name=contributor_name;
        this.expense=expense;
        this.paid=paid;
    }

    public String getContributor_name() {
        return contributor_name;
    }

    public void setContributor_name(String contributor_name) {
        this.contributor_name = contributor_name;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public Float getExpense() {
        return expense;
    }

    public void setExpense(Float expense) {
        this.expense = expense;
    }

    public Float getPaid() {
        return paid;
    }

    public void setPaid(Float paid) {
        this.paid = paid;
    }
}
