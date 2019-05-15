package com.javaeeeee.resources;

import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.DAO.personService;
import com.javaeeeee.api.person;
import com.javaeeeee.api.Representation;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import com.javaeeeee.api.person;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class personResource {
    private final personService personServiceObj;


    public personResource(personService personServiceObj) {
        this.personServiceObj=personServiceObj;
    }

    @GET
    @Timed
    public Representation<List<person>> getPersons() {
        return new Representation<List<person>>(HttpStatus.OK_200, personServiceObj.getPersons());
    }


    @GET
    @Timed
    @Path("{id}")
    public Representation<person> getPerson(@PathParam("id") final int id) {
        return new Representation<person>(HttpStatus.OK_200, personServiceObj.getPerson(id));
    }


    @POST
    @Timed
    public Representation <List<person>> createPerson(@NotNull @Valid final person personObj) {
        return new Representation <List<person>>(HttpStatus.OK_200, personServiceObj.createPerson(personObj));
    }

//    @GET
//    @Timed
//    @Path("{name}")
//    public Response updatePerson(@PathParam("name") final String name, final person personObj){
//
//        personServiceObj.updatePerson(personObj);
//        return Response.ok().build();
//    }


}
