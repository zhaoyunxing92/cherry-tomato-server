package com.sunny.boot.cherrytomato;

import com.sunny.boot.cherrytomato.core.config.AppWebMvcConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AppWebMvcConfigurerAdapter.class})
public class CherryTomatoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CherryTomatoApplication.class, args);
  }
}
