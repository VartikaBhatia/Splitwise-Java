package com.javaeeeee.resources;

import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.api.Representation;
import com.javaeeeee.api.person;
import com.javaeeeee.api.member;
import com.javaeeeee.api.contributor;
import com.javaeeeee.api.bill;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.javaeeeee.DAO.splitService;


import java.util.List;

@Path("/splitByBill")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class splitResource {

    private splitService splitServiceObj;
    private member memberObj;
    private person personObj;
    private String name,groupName;
    private float expense,paid,total,balance;

    public splitResource(splitService splitServiceObj){

        this.splitServiceObj=splitServiceObj;

    }

    @GET
    @Timed
    @Path("{bill_name}")

    public Response getBill(@PathParam("bill_name") final String bill_name) {

        List<contributor> contributorList = splitServiceObj.getContributors(bill_name);

        for (contributor s:contributorList){
            name=s.getContributor_name();
            System.out.println("NAme :" +name);
            expense=s.getExpense();
            paid=s.getPaid();
            total=expense-paid;
            balance=splitServiceObj.getTotalPerson(name);
            person personObj=splitServiceObj.getPersonByName(name);
            personObj.setTotal(balance+total);
            splitServiceObj.updatePerson(personObj);


            groupName=splitServiceObj.getGroupName(bill_name);
            balance=splitServiceObj.getTotalMember(name,groupName);
            member memberObj=splitServiceObj.getMemberObj(name,groupName);
            memberObj.setTotal(total+balance);
            splitServiceObj.updateMember(memberObj);


        }

        return Response.ok().build();


    }


    @GET
    @Timed
    @Path("/getPersonBalance/{name}")
    public person getPersonByName(@PathParam("name") final String name){
        return splitServiceObj.getPersonByName(name);
    }

    @GET
    @Timed
    @Path("/getGroupTotal/{mem_name}")
    public List<member> getTotalPerGroup(@PathParam("mem_name") final String mem_name){
        return splitServiceObj.getMember(mem_name);
    }


}
