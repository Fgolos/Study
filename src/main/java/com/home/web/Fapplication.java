package com.home.web;

import com.google.common.io.Resources;
import com.home.web.resources.TimeEndpoint;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Fapplication extends Application<Fconfiguration> {
  @Override
  public void run(final Fconfiguration fconfiguration, final Environment environment)
  throws Exception {
    environment.jersey().register(new TimeEndpoint());
  }

  public static void main(String[] args)
  throws Exception {
    final String ymlConfig = Resources.getResource("web-server-config.yml").getFile();
    new Fapplication().run("server", ymlConfig);
  }
}
