package com.sunny.boot.cherrytomato;

import com.sunny.boot.cherrytomato.core.config.AppConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.sunny.boot.cherrytomato.**.mapper")
@Import({AppConfig.class})
public class CherryTomatoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CherryTomatoApplication.class, args);
  }
}
