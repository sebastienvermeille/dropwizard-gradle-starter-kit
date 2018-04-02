package ch.svermeille.dropwizard.example.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.codahale.metrics.annotation.Timed;

import ch.svermeille.dropwizard.example.api.Saying;

import static javax.ws.rs.core.MediaType.*;

@Path("/hello-world")
@Produces(APPLICATION_JSON)
public class MyResource {

  private final String template;
  private final String defaultName;
  private final AtomicLong counter;

  public MyResource(String template, String defaultName) {
    this.template = template;
    this.defaultName = defaultName;
    this.counter = new AtomicLong();
  }

  @GET
  @Timed
  public Saying sayHello(@QueryParam("name") Optional<String> name) {
    final String value = String.format(template, name.orElse(defaultName));
    return new Saying(counter.incrementAndGet(), value);
  }

}
