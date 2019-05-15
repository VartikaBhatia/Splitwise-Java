package com.javaeeeee.DAO;

import com.javaeeeee.api.Part;
import com.javaeeeee.api.person;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class personService {
    @CreateSqlObject
    abstract personDao personDaoObj();

    public List<person> getPersons() {
        return personDaoObj().getPersons();
    }

    public person getPerson(int id) {
        person personObj = personDaoObj().getPerson(id);

        return personObj;
    }

    public List<person> createPerson(person personObj) {
        personDaoObj().createPerson(personObj);
        return personDaoObj().getPersons();
    }

    public void updatePerson(person personObj) {

        personDaoObj().updatePerson(personObj);
    }
}
