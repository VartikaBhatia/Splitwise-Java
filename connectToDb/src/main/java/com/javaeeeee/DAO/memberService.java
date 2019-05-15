package com.javaeeeee.DAO;

import com.javaeeeee.api.member;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class memberService {

    @CreateSqlObject
    abstract memberDao memberDaoObj();

    public List<member> getMembers() {
        return memberDaoObj().getMembers();
    }



    public List<member> createMember(member memberObj) {
        memberDaoObj().createMember(memberObj);
        return memberDaoObj().getMembers();
    }


}
