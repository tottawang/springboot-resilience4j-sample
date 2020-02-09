package com.sample.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;

@Configuration
public class Resilience4jConfig {

  @Bean(name = "myRetry")
  public Retry myRetry() {
    RetryConfig config = RetryConfig.custom().maxAttempts(5)
        .intervalFunction(IntervalFunction.ofExponentialBackoff(5000, 2)).build();
    return Retry.of("myRetryConfig", config);
  }

  @Bean(name = "expontentialBackOff")
  public IntervalFunction expontentialBackOff() {
    return IntervalFunction.ofExponentialBackoff(1000, 1.5);
  }

}
