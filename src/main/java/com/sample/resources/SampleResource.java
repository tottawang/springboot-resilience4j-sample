package com.sample.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.domain.User;

@Path("/api")
@Produces("application/json")
public class SampleResource {

  @Autowired
  private UserRepository userRepository;

  @GET
  @Path("/users")
  @Produces("application/json")
  public List<User> getLocalCacheUsers() {
    return userRepository.getEmptyUsers();
  }
}
