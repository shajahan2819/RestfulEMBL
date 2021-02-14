package com.embl.RestfulEmbl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.embl.RestfulEmbl.model.Person;
import com.embl.RestfulEmbl.repository.PersonRepository;

@SpringBootApplication
public class RestfulEmblApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulEmblApplication.class, args);
	}
	
	@Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            repository.save(new Person(new Long("1"),"Mohamed","Shajahan","Green",35));
            repository.save(new Person(new Long("2"),"John","Wakefield","Red",42));
            repository.save(new Person(new Long("3"),"Rosie","Binns","Blue",25));
        };
    }
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

}
