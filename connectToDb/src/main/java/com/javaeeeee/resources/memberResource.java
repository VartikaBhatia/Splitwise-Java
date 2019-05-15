package com.javaeeeee.resources;

import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.DAO.memberService;
import com.javaeeeee.api.Representation;
import com.javaeeeee.api.member;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/member")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class memberResource {

    private final memberService memberServiceObj;


    public memberResource(memberService memberServiceObj) {
        this.memberServiceObj=memberServiceObj;
    }

    @GET
    @Timed
    public Representation<List<member>> getMembers() {
        return new Representation<List<member>>(HttpStatus.OK_200, memberServiceObj.getMembers());
    }


//    @GET
//    @Timed
//    @Path("{mem_name}")
//    public Representation<member> getMember(@PathParam("id") final String mem_name) {
//        return new Representation<member>(HttpStatus.OK_200, memberServiceObj.getMember(mem_name));
//    }


    @POST
    @Timed
    public Representation<List<member>> createPerson(@NotNull @Valid final member memberObj) {
        return new Representation<List<member>>(HttpStatus.OK_200, memberServiceObj.createMember(memberObj));
    }
}
