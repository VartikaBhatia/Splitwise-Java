package com.javaeeeee.DAO;

import com.javaeeeee.api.bill;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class billService {

    @CreateSqlObject
    abstract billDao billDaoObj();


    public List<bill> getBill() {
        return billDaoObj().getBill();
    }

    public List<bill> createBill(bill billObj) {
        billDaoObj().createBill(billObj);

        return billDaoObj().getBill();
    }

}
