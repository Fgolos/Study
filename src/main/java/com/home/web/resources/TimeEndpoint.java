package com.home.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("api")
public class TimeEndpoint {
  @Path("/text")
  @GET
  public String text() {
    return "Hello it is text " + System.currentTimeMillis();
  }
}
