package AngelusDaniel.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    
    // Via EXTENSION. http://localhost:8080/api/person/v1/4.xml http://localhost:8080/api/person/v1/4.JSON Deprecated on Spring 2.6

    // Via Query Param. http://localhost:8080/api/person/v1/4?mediaType=xml http://localhost:8080/api/person/v1/4?mediaType=json

    // configurer.favorParameter(true)
    //       .parameterName("mediType")
    //       .ignoreAcceptHeader(true)
    //       .useRegisteredExtensionsOnly(false)
    //       .defaultContentType(MediaType.APPLICATION_JSON)
    //       .mediaType("json", MediaType.APPLICATION_JSON)
    //       .mediaType("xml", MediaType.APPLICATION_XML);

    //Via Header. http://localhost:8080/api/person/v1/4
    configurer.favorParameter(false)
          .ignoreAcceptHeader(false)
          .defaultContentType(MediaType.APPLICATION_JSON)
          .mediaType("json", MediaType.APPLICATION_JSON)
          .mediaType("xml", MediaType.APPLICATION_XML)
          .mediaType("yaml", MediaType.APPLICATION_YAML);

  }

  
  

}
