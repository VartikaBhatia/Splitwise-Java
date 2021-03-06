package com.javaeeeee.resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import com.javaeeeee.api.Representation;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.jetty.http.HttpStatus;
import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.api.Part;
import com.javaeeeee.DAO.PartsService;

@Path("/parts")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class PartsResource {
    private final PartsService partsService;

    public PartsResource(PartsService partsService) {
        this.partsService = partsService;
    }

    @GET
    @Timed
    public Representation<List<Part>> getParts() {
        return new Representation<List<Part>>(HttpStatus.OK_200, partsService.getParts());
    }

    @GET
    @Timed
    @Path("{id}")
    public Representation<Part> getPart(@PathParam("id") final int id) {
        return new Representation<Part>(HttpStatus.OK_200, partsService.getPart(id));
    }

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Representation<Part> createPart(@NotNull @Valid final Part part) {
        return new Representation<Part>(HttpStatus.OK_200, partsService.createPart(part));
    }

    @PUT
    @Timed
    @Path("{id}")
    public Representation<Part> editPart(@NotNull @Valid final Part part,
                                         @PathParam("id") final int id) {
        part.setId(id);
        return new Representation<Part>(HttpStatus.OK_200, partsService.editPart(part));
    }

    @DELETE
    @Timed
    @Path("{id}")
    public Representation<String> deletePart(@PathParam("id") final int id) {
        return new Representation<String>(HttpStatus.OK_200, partsService.deletePart(id));
    }
}