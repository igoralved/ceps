package ceps.src.main.java.com.example.acessingdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CEPApplication {

	public static void main(String[] args) {
		SpringApplication.run(CEPApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(CEPRepository repository) {
	    return (args) -> {
	      // save a few ceps
	      repository.save(new CEP("01001000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo",
	    		  "SP", "3550308", "1004", "11", "7107"));
	    };
	}
}
