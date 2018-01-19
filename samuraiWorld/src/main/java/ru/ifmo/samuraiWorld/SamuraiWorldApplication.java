package ru.ifmo.samuraiWorld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ifmo.samuraiWorld.data.Samurai;
import ru.ifmo.samuraiWorld.data.SamuraiRepository;

@SpringBootApplication
public class SamuraiWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamuraiWorldApplication.class, args);

	}
	@Bean
	public CommandLineRunner demo(){
		return(args)->{
			Samurai samurai = new Samurai("qwer", (short)12);
			samurai.saveOrUpdate();
		};

	}
}
