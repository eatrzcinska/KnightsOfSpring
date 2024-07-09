package com.clockworkjava.knigthsofspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
//@ImportResource("classpath:spring-config.xml") // ? nie wiem
@ComponentScan ({"com.clockworkjava"})
public class KursspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursspringApplication.class, args);
	}

}
