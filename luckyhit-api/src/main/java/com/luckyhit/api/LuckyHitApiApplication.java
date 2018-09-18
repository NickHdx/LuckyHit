package com.luckyhit.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.luckyhit.mapper")
@ComponentScan("com.luckyhit")
public class LuckyHitApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LuckyHitApiApplication.class, args);
	}
}
