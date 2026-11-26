package com.zixi.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Administrator
 */
@RestController
public class ChatController {

    @Resource
    private ChatModel chatModel;

    @Resource
    private ChatClient chatClient;

    @GetMapping("/doChat")
    public String doChat(@RequestParam(value = "msg") String msg){
        return chatModel.call(msg);
    }

    @GetMapping("/steamChat")
    public Flux<String> steamChat(@RequestParam(value = "msg") String msg){
        return chatModel.stream(msg);
    }

}
