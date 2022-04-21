package com.whatsapp.mensajeria.DemoWApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeRequest {
    private String sender;
    private String message;
}
