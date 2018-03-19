package com.example.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@MapperScan("com.example.bookstore.mapper")
@ComponentScan("com.example.bookstore")
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);
	}
}
