package com.sample.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sample.domain.User;

@Repository
public class UserRepository {

  private static int index = 0;

  public List<User> getUsers() {

    index++;
    UserService.printTestLog("getUsers");

    if (index != 5) {
      throw new RuntimeException("test");
    }

    List<User> users = new ArrayList<>();
    User newUser = new User(1000L, "tester");
    users.add(newUser);
    return users;
  }



}
