package com.javaeeeee;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.sql.DataSource;
import com.javaeeeee.resources.PartsResource;
import com.javaeeeee.resources.contributorResource;
import com.javaeeeee.resources.billResource;
import com.javaeeeee.resources.personResource;
import com.javaeeeee.resources.groupResource;
import com.javaeeeee.resources.memberResource;
import com.javaeeeee.DAO.PartsService;
import com.javaeeeee.DAO.personService;
import com.javaeeeee.DAO.billService;
import com.javaeeeee.DAO.memberService;
import com.javaeeeee.DAO.groupService;
import com.javaeeeee.DAO.contributorService;
import com.javaeeeee.DAO.splitService;
import com.javaeeeee.resources.splitResource;


import org.skife.jdbi.v2.DBI;


public class connectToDbApplication extends Application<connectToDbConfiguration> {

    private static final String SQL = "sql";
    private static final String DROPWIZARD_BLOG_SERVICE = "Dropwizard blog service";
    private static final String BEARER = "Bearer";

    public static void main(final String[] args) throws Exception {
        new connectToDbApplication().run(args);
    }

    @Override
    public String getName() {
        return "connectToDb";
    }

    @Override
    public void initialize(final Bootstrap<connectToDbConfiguration> bootstrap) {
    }

    @Override
    public void run(final connectToDbConfiguration configuration,
                    final Environment environment) {

        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        environment.jersey().register(new PartsResource(dbi.onDemand(PartsService.class)));
        environment.jersey().register(new personResource(dbi.onDemand(personService.class)));
        environment.jersey().register(new groupResource(dbi.onDemand(groupService.class)));
        environment.jersey().register(new memberResource(dbi.onDemand(memberService.class)));
        environment.jersey().register(new billResource(dbi.onDemand(billService.class)));
        environment.jersey().register(new contributorResource(dbi.onDemand(contributorService.class)));
        environment.jersey().register(new splitResource(dbi.onDemand(splitService.class)));

    }

}
