package com.weekend.messenger.controller;

import com.weekend.messenger.dto.MessageDTO;
import com.weekend.messenger.service.MessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    private Environment env;

    @Value("${spring.application.name}") // Use : to provide a default value
    private static String serverPort;

    @RequestMapping( value = "/checkValid/", method = RequestMethod.GET)
    public void testValidator(@RequestParam @Size(min=10, max=10) String testString,
    @RequestParam @Email String email
    ){
        System.out.println(env.getProperty("server.port"));
        System.out.println("It's valid");
    }

    @PostMapping("/sendMessage/")
    public ResponseEntity<String> sendMessage(@RequestBody @Valid MessageDTO messageDTO){
        System.out.println(messageService.sendMessage(messageDTO));
       return ResponseEntity.ok("Message Sent!");
    }

    @GetMapping("/receiveMessage/")
    public ResponseEntity<String> receiveMessage(@RequestParam @NotNull long id){
        return ResponseEntity.ok(messageService.receiveMessage(id));
    }
}
