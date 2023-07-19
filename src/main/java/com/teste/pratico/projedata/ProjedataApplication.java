package com.teste.pratico.projedata;

import com.teste.pratico.projedata.service.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjedataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjedataApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(Principal principal) {
		return args -> {
//			Principal principal = new Principal();
			principal.execute();
		};
	}

}
