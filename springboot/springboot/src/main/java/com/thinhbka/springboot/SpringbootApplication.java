package com.thinhbka.springboot;
import com.thinhbka.springboot.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.thinhbka")
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	@Bean
	public Latop laptop1() {
		System.out.println("a laptop was create!");
		Latop laptop = new Latop();
		laptop.setId(0);
		laptop.setName("my laptop");
		return laptop;
	}
}
