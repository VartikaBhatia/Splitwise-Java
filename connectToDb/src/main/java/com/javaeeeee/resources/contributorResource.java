package com.javaeeeee.resources;

import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.DAO.contributorService;
import com.javaeeeee.api.Representation;
import com.javaeeeee.api.contributor;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contributor")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class contributorResource {
    private final contributorService contributorServiceObj;


    public contributorResource(contributorService contributorServiceObj) {
        this.contributorServiceObj=contributorServiceObj;
    }

    @GET
    @Timed
    public Representation<List<contributor>> getGroups() {
        return new Representation<List<contributor>>(HttpStatus.OK_200, contributorServiceObj.getContributors());
    }


    @POST
    @Timed
    public Representation<List<contributor>> createPerson(@NotNull @Valid final contributor contributorObj) {
        return new Representation<List<contributor>>(HttpStatus.OK_200, contributorServiceObj.createContributors(contributorObj));
    }
}
