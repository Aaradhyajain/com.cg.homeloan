package com.cg.homeloan;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// devtools dependency 

@SpringBootApplication
public class Application {

	//private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		//LOG.info("Start...");
		System.out.println("hello");

		SpringApplication.run(Application.class, args);

	}
}
	