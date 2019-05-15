package com.javaeeeee.resources;

import com.codahale.metrics.annotation.Timed;
import com.javaeeeee.DAO.billService;
import com.javaeeeee.api.Representation;
import com.javaeeeee.api.bill;
import org.eclipse.jetty.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bill")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class billResource {

    private final billService billServiceObj;


    public billResource(billService billServiceObj) {
        this.billServiceObj=billServiceObj;
    }

    @GET
    @Timed
    public Representation<List<bill>> getBill() {
        return new Representation<List<bill>>(HttpStatus.OK_200, billServiceObj.getBill());
    }

    @POST
    @Timed
    public Representation<List<bill>> createPerson(@NotNull @Valid final bill billObj) {
        return new Representation<List<bill>>(HttpStatus.OK_200, billServiceObj.createBill(billObj));
    }
}
