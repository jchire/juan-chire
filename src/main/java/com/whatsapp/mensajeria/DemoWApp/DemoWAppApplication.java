package com.whatsapp.mensajeria.DemoWApp;

import com.whatsapp.mensajeria.DemoWApp.mensaje.Mensaje;
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
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Mensaje> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("ejemploTopic",
                    Mensaje.builder()
                            .fromUser("jonas")
                            .toUser("gotan")
                            .message("Hellloooooo!")
                            .timestamp(LocalDateTime.now())
                            .build()
                    );
        };
    }
}
