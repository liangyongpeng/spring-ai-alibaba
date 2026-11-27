package com.zixi.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/hello/chatModel")
public class ChatModelController {

    /**
     * ChatModel 支持自动注入
     */
    @Resource
    private ChatModel chatModel;

    @GetMapping("/doChat")
    public String doChat(@RequestParam(value = "msg",defaultValue = "你是谁？") String msg){
        return chatModel.call(msg);
    }

    @GetMapping("/steamChat")
    public Flux<String> steamChat(@RequestParam(value = "msg",defaultValue = "你是谁？") String msg){
        return chatModel.stream(msg);
    }

}
