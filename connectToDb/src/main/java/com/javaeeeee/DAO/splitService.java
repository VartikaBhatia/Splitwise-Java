package com.javaeeeee.DAO;

import com.javaeeeee.api.bill;
import com.javaeeeee.DAO.billDao;
import com.javaeeeee.DAO.memberDao;
import com.javaeeeee.DAO.personDao;
import com.javaeeeee.DAO.contributorDao;
import com.javaeeeee.api.contributor;
import com.javaeeeee.api.member;
import com.javaeeeee.api.person;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class splitService {
    @CreateSqlObject
    abstract billDao billDaoObj();
    @CreateSqlObject
    abstract contributorDao contributorDaoObj();
    @CreateSqlObject
    abstract memberDao memberDaoObj();
    @CreateSqlObject
    abstract personDao personDaoObj();

    public bill getBill(String  name) {
        return billDaoObj().getBill(name);
    }

    public List<contributor> getContributors(String bill_name) {
        //System.out.println(contributorDaoObj().getContributors(bill_name));
        return contributorDaoObj().getContributors(bill_name);
    }

    public Float getTotalPerson(String name) {
        Float total = personDaoObj().getTotal(name);

        return total;
    }

    public void updatePerson(person personObj) {

        personDaoObj().updatePerson(personObj);
    }

    public String getGroupName(String  bill_name) {
        return billDaoObj().getGroupName(bill_name);

    }

    public float getTotalMember(String mem_name,String group_name) {
        return memberDaoObj().getTotal(mem_name,group_name);
    }

    public member getMemberObj(String mem_name,String group_name) {
        return memberDaoObj().getMemberObj(mem_name,group_name);
    }

    public void updateMember(member memberObj) {
        memberDaoObj().updateMember(memberObj);
    }

    public person getPersonByName(String name) {
        person personObj = personDaoObj().getPersonByName(name);

        return personObj;
    }

    public List<member> getMember(String mem_name) {
         return memberDaoObj().getMember(mem_name);

    }

}
