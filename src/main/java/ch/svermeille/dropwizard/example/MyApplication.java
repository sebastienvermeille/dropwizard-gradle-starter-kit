package ch.svermeille.dropwizard.example;

import ch.svermeille.dropwizard.example.resources.MyResource;
import ch.svermeille.dropwizard.example.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyConfiguration> {

  public static void main(String[] args) throws Exception {
    new MyApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-world";
  }

  @Override
  public void initialize(Bootstrap<MyConfiguration> bootstrap) {
    // nothing to do yet

  }

  @Override
  public void run(MyConfiguration configuration, Environment environment) {

    final MyResource resource = new MyResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
    );

    final TemplateHealthCheck healthCheck =
        new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);

    environment.jersey().register(resource);

  }
}
