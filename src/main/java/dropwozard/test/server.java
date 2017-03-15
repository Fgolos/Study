package dropwozard.test;

import javax.ws.rs.*;

class Server {

    public Server() {
    }

    @GET
    @Path("/time")
    public long time() {
        return System.currentTimeMillis();
    }

}