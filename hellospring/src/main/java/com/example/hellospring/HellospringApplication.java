package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {
		System.out.println("  .   ____          _            __ _ _\n"
				+ " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n"
				+ "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n"
				+ " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n"
				+ "  '  |____| .__|_| |_|_| |_\\__, | / / / /\n"
				+ " =========|_|==============|___/=/_/_/_/\n"
				+ " :: Spring Boot ::                (v2.7.5)");
		SpringApplication.run(HellospringApplication.class, args);
	}

}
