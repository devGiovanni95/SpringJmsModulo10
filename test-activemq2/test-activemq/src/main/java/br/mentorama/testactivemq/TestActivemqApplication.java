package br.mentorama.testactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
/*@EnableAsync
@ComponentScan(basePackages = {"br.mentorama.testactivemq"})*/
public class TestActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestActivemqApplication.class, args);
	}

}
