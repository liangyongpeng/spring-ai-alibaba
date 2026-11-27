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
 * @desc 多模型共存
 */
@RestController
@RequestMapping("/stream/chatModel")
public class ChatModelController {

    /**
     * V1 配置 ChatModel 支持自动注入
     */
    @Resource(name = "deepSeekChatModel")
    private ChatModel deepSeekChatModel;

    @Resource(name = "qwenChatModel")
    private ChatModel qwenChatModel;

    @GetMapping("/deepseekSteamChatModel")
    public Flux<String> deepseekSteamChatModel(@RequestParam(value = "msg",defaultValue = "你是谁？") String msg){
        return deepSeekChatModel.stream(msg);
    }

    @GetMapping("/qwenSteamChatModel")
    public Flux<String> qwenSteamChatModel(@RequestParam(value = "msg",defaultValue = "你是谁？") String msg){
        return qwenChatModel.stream(msg);
    }

    /**
     * V2 配置 ChatModel 支持自动注入
     */
    @Resource(name = "deepSeekChatClient")
    private ChatClient deepSeekChatClient;

    @Resource(name = "qwenChatClient")
    private ChatClient qwenChatClient;

    @GetMapping("/deepseekSteamChatClient")
    public Flux<String> deepseekSteamChatClient(@RequestParam(value = "msg",defaultValue = "你是谁？") String msg){
        return deepSeekChatClient.prompt().user(msg).stream().content();
    }

    @GetMapping("/qwenSteamChatClient")
    public Flux<String> qwenSteamChatClient(@RequestParam(value = "msg",defaultValue = "你是谁？") String msg){
        return qwenChatClient.prompt().user(msg).stream().content();
    }

}
