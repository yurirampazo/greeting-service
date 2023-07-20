package com.microservices.greetingservice.controller;


import com.microservices.greetingservice.config.GreetingConfig;
import com.microservices.greetingservice.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @Autowired
  private GreetingConfig config;
  private static final String template = "%s, %s";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping
  public Greeting greet(@RequestParam(value = "name",
        defaultValue = "") String name) {

    if (name.isEmpty()) name = config.getDefaultValue();

    return new Greeting(counter.incrementAndGet(), String.format(template, config.getGreeting(), name));
  }
}
