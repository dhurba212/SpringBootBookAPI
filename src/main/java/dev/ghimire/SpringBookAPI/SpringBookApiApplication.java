package dev.ghimire.SpringBookAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"dev.ghimire"})//tell spring to check all packages for components
@EnableJpaRepositories(basePackages = {"dev.ghimire.repos"})//tell spring data where your repos are
@EntityScan(basePackages = {"dev.ghimire.entities"})//Tell spring Data where to find your entities. IN base hibernate we did this in cfg.xml file
@SpringBootApplication //this is a spring boot app and this is the main file
public class SpringBookApiApplication {

	public static void main(String[] args) {
		//spring boot is creating an application context for us and auto creating some helpful beans we might need
		SpringApplication.run(SpringBookApiApplication.class, args);
	}

}
