package com.zixi.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
@Configuration
public class SaaLLMConfig {

    @Value("${spring.ai.dashscope.api-key}")
    private String apiKey;

    @Bean
    public DashScopeApi dashScopeApi(){
        return DashScopeApi.builder().apiKey(apiKey).build();
    }

    /**
     * 按照官网第二种创建 ChatClient 对象方式
     */
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder.build();
    }

}
