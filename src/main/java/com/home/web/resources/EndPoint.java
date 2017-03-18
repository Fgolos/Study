package com.home.web.resources;

import com.home.web.Time;
import test.Search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by FDR on 15.03.2017.
 */
@Path("api")
@Produces(MediaType.APPLICATION_JSON)

public class EndPoint {
    @Path("/time")
    @GET
    public Time time() {
        Time time = new Time((long) 1);
        return time;
    }

    @Path("/time2")
    @GET
    public Time time2() {
        Time time = new Time((long) 1);
        return time;
    }

    @Path("/string/{hui}")
    @GET
    public File string(@PathParam("hui") String omg) {
        Search search = new Search("C:\\Users\\Fgolo\\Pictures", omg);
        ArrayList<File> search1 = search.search();
        return search1.get(0);
    }
}
