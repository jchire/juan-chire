package com.whatsapp.mensajeria.DemoWApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {
    private String sender;
    private String content;
    private String timestamp;
}
