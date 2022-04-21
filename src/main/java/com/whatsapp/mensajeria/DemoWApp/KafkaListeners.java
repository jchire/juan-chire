package com.whatsapp.mensajeria.DemoWApp;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "ejemploTopic",
            groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }

    @KafkaListener(topics = "ejemploTopic", groupId = "groupId")
    void listener2(String data) {
        System.out.println("Listener received: " + data);
    }


}
