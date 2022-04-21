package com.whatsapp.mensajeria.DemoWApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoWAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, Mensaje> kafkaTemplate){
		return args ->{
			kafkaTemplate.send("ejemploTopic",
					new Mensaje(
							"jonas",
							"Hellooooo",
							LocalDateTime.now().toString()
					));
		};
	}
}
