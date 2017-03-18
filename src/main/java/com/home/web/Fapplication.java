package com.home.web;

import com.google.common.io.Resources;
import com.home.web.resources.EndPoint;
import com.home.web.resources.TimeEndpoint;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Fapplication extends Application<Configuration> {

  @Override
  public void run(final Configuration configuration, final Environment environment)
  throws Exception {
    environment.jersey().register(new TimeEndpoint());
    environment.jersey().register(new EndPoint());
  }

  public static void main(String[] args)
  throws Exception {
    final String ymlConfig = Resources.getResource("web-server-config.yml").getFile();
    new Fapplication().run("server", ymlConfig);
  }
}
