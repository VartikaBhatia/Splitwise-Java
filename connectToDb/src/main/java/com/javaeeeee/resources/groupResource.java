package com.javaeeeee.resources;

import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.DAO.groupService;
import com.javaeeeee.api.Representation;
import com.javaeeeee.api.group_table;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/group")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class groupResource {

    private final groupService groupServiceObj;


    public groupResource(groupService groupServiceObj) {
        this.groupServiceObj=groupServiceObj;
    }

    @GET
    @Timed
    public Representation<List<group_table>> getGroups() {
        return new Representation<List<group_table>>(HttpStatus.OK_200, groupServiceObj.getGroups());
    }


    @GET
    @Timed
    @Path("{id}")
    public Representation<group_table> getGroup(@PathParam("id") final String id) {
        return new Representation<group_table>(HttpStatus.OK_200, groupServiceObj.getGroup(id));
    }


    @POST
    @Timed
    public Representation<group_table> createGroup(@NotNull @Valid final group_table groupObj) {
        return new Representation<group_table>(HttpStatus.OK_200, groupServiceObj.createGroup(groupObj));
    }
}
