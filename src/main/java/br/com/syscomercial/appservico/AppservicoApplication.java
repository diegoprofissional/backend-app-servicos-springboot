package br.com.syscomercial.appservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
public class AppservicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppservicoApplication.class, args);
	}

}
