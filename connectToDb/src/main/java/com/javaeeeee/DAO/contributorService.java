package com.javaeeeee.DAO;

import com.javaeeeee.api.contributor;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class contributorService {

    @CreateSqlObject
    abstract contributorDao contributorDaoObj();

    public List<contributor> getContributors() {
        return contributorDaoObj().getContributors();
    }



//    public member getMember(String mem_name) {
//        member memberObj =memberDaoObj().getMember(mem_name);
//
//        return memberObj;
//    }

    public List<contributor> createContributors(contributor contributorObj) {
        contributorDaoObj().createContributors(contributorObj);
        return contributorDaoObj().getContributors();
    }
}
