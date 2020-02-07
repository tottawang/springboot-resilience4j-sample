package com.sample.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sample.domain.User;

@Repository
public class UserRepository {

  public List<User> getEmptyUsers() {
    List<User> users = new ArrayList<>();
    User newUser = new User(1000L, "tester");
    users.add(newUser);
    return users;
  }

}
