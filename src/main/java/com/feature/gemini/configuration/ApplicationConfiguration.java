package com.feature.gemini.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info().title("VertexAI Gemini API").version("0.0.1")
            .license(new License().name("Bank 2.0").url("http://www.app.ai")));
  }

}
