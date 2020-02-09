package com.sample.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sample.domain.User;

import io.github.resilience4j.retry.Retry;

@Component
public class UserService {

  @Autowired
  @Qualifier("myRetry")
  private Retry myRetry;

  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers() {
    printTestLog("start");
    Function<String, List<User>> pingPongFn =
        Retry.decorateFunction(myRetry, ping -> userRepository.getUsers());
    return pingPongFn.apply("Hello");
  }

  public static void printTestLog(String desc) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    System.out.println(formatter.format(date) + ": " + desc);
  }
}
