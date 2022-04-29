package edu.tcu.cs.superfrogscheduler;

import edu.tcu.cs.superfrogscheduler.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SuperfrogschedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperfrogschedulerApplication.class, args);

	}

	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1, 1);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}

