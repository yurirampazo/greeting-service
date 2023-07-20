package com.microservices.greetingservice.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@EnableConfigurationProperties
@ConfigurationProperties("greeting-service")
public class GreetingConfig {

  private String greeting;
  private String defaultValue;
}
