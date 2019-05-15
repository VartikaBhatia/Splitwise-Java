package com.javaeeeee.api;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class person {
    @JsonProperty
    private int  id;
    private int age;
    private String name;
    private Float total;

    public person()
    {
        super();
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public person(int  id, String name, Float total,int age) {
        super();
        this.name = name;
        this.id=id;
        this.total=total;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int geId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(total, person.total);
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, total);
    }
}
