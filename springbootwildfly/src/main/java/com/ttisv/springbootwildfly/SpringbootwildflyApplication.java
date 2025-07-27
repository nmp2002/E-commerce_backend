package com.ttisv.springbootwildfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// Spring Boot 2.x
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Spring Boot 1.x
//import org.springframework.boot.web.support.SpringBootServletInitializer;


@SuppressWarnings("unused")
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringbootwildflyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringbootwildflyApplication.class);
		application.setAdditionalProfiles("ssl");
		application.run(args);
		// SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
		//CallAPI.getInstance();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<SpringbootwildflyApplication> applicationClass = SpringbootwildflyApplication.class;
}

@RestController
class HelloController {

	@RequestMapping("/hello/{name}")
	String hello(@PathVariable String name) {

		return "Hi " + name + " !";

	}

	@RequestMapping("/main")
	String main() {
		try {
			return "Hi " +  " !";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Loi roi !";
	}
}
