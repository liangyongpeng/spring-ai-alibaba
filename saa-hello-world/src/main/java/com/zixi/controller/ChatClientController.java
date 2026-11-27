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
@RequestMapping("/hello/chatClient")
public class ChatClientController {

    /**
     * ChatClient 不支持自动注入，需要手动创建
     * 官网说明：https://sca.aliyun.com/en/docs/ai/tutorials/chat-client/?spm=7145af80.321ad293.0.0.72aa5e63U3whQB#%E4%BD%BF%E7%94%A8%E8%87%AA%E5%8A%A8%E9%85%8D%E7%BD%AE%E7%9A%84-chatclientbuilder
     */
/*    @Resource
    private ChatClient chatClient;*/

    /**
     * 按照官网第一种创建 ChatClient 对象方式，通过构造方法注入。
     */
/*    private final ChatClient chatClient;

    public ChatClientController(ChatModel  chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
    }*/

    /**
     * 第二种方法，在SaaLLMConfig配置类中创建一个ChatClient的Bean，然后使用自动注入方式。
     */
    @Resource
    private ChatClient chatClient;

    @GetMapping("/doChat")
    public String doChat(@RequestParam(value = "msg", defaultValue = "你是谁？") String msg) {
        return chatClient.prompt().user(msg).call().content();
    }

    @GetMapping("/steamChat")
    public Flux<String> steamChat(@RequestParam(value = "msg", defaultValue = "你是谁？") String msg) {
        return chatClient.prompt().user(msg).stream().content();
    }

}
