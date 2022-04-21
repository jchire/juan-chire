package com.whatsapp.mensajeria.DemoWApp;

import com.whatsapp.mensajeria.DemoWApp.mensaje.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MensajeController {
    @Autowired
    private KafkaTemplate<String, Mensaje> kafkaTemplate;

    public MensajeController(KafkaTemplate<String, Mensaje> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MensajeRequest request){
        //Mensaje mensaje = new Mensaje(request.getSender(),request.getMessage(), LocalDateTime.now().toString());
        Mensaje mensaje = Mensaje.builder()
                .fromUser(request.getFromUser())
                .toUser(request.getToUser())
                .message(request.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        kafkaTemplate.send("ejemploTopic",mensaje);
    }
}
