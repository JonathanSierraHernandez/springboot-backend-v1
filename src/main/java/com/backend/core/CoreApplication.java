package com.backend.core;

import com.backend.model.Inout;
import com.backend.model.Usr;
import com.backend.repository.InoutRepository;
import com.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = "com.backend")
@EntityScan("com.backend.model")
@EnableJpaRepositories("com.backend.repository")
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");


			}
		};
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, InoutRepository inOutRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel", "Jonathan", "Michele", "Jean", "Henrique", "Betania", "Marlene","Milton", "Antonio", "Francisca", "Pepe", "Jose").forEach(name -> {
				Usr usr = new Usr(name, "Sierra", "58745874", name.toLowerCase() + "@domain.com", "Palau de Plegamans", "5874x58");
				Inout inout = new Inout(usr, "2022-06-23T14:36:10.000Z", "2022-06-24T20:36:10.000Z");
				userRepository.save(usr);
				inOutRepository.save(inout);
			});
			userRepository.findAll().forEach(System.out::println);
		};


	}
}
