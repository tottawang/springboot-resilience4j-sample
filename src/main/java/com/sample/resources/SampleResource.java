package com.sample.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.domain.User;

import io.github.resilience4j.core.IntervalFunction;

@Path("/api")
@Produces("application/json")
public class SampleResource {

  @Autowired
  private UserService userService;

  @Autowired
  public IntervalFunction expontentialBackoff;

  @GET
  @Path("/users")
  @Produces("application/json")
  public List<User> getLocalCacheUsers() {
    return userService.getUsers();
  }

  @POST
  @Produces("application/json")
  public void testExpontentialBackoff() {
    System.out.println("attempt1: " + expontentialBackoff.apply(1));
    System.out.println("attempt2: " + expontentialBackoff.apply(2));
    System.out.println("attempt3: " + expontentialBackoff.apply(3));
    System.out.println("attempt4: " + expontentialBackoff.apply(4));
    System.out.println("attempt5: " + expontentialBackoff.apply(5));
    System.out.println("attempt6: " + expontentialBackoff.apply(6));
    System.out.println("attempt7: " + expontentialBackoff.apply(7));
    System.out.println("attempt8: " + expontentialBackoff.apply(8));
    System.out.println("attempt9: " + expontentialBackoff.apply(9));
    System.out.println("attempt10: " + expontentialBackoff.apply(10));
  }
}
