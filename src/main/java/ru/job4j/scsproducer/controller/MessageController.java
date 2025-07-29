package ru.job4j.scsproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/srsprod")
@Slf4j
public class MessageController {

    private final StreamBridge streamBridge;

    public MessageController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @GetMapping("/send")
    public String sendMessage() {
        String message0 = "message from controller";
        streamBridge.send("output0", message0);

        String message1 = "message from controller1";
        streamBridge.send("output1", message1);

        log.info("send to scs1-source : {}", message0);
        log.info("send to scs2-source : {}", message1);

        return "Message send: " + message1;
    }
}
