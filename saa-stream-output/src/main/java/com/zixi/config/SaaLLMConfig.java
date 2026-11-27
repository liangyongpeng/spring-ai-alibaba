package com.zixi.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /**
     * 配置两个模型，是系统支持多模型共存
     */
    private static final String DEEP_SEEK_MODEL = "deepseek-v4-pro";

    private static final String QIAN_WEN_MODEL = "qwen-plus";

    /**
     * 配置chartModel 的 deepSeek模型
     */
    @Bean
    public ChatModel deepSeekChatModel() {
        return DashScopeChatModel.builder().dashScopeApi(DashScopeApi.builder().apiKey(apiKey).build())
                .defaultOptions(DashScopeChatOptions.builder().withModel(DEEP_SEEK_MODEL).build())
                .build();
    }

    /**
     * 配置chartModel 的 qwen模型
     */
    @Bean
    public ChatModel qwenChatModel() {
        return DashScopeChatModel.builder().dashScopeApi(DashScopeApi.builder().apiKey(apiKey).build())
                .defaultOptions(DashScopeChatOptions.builder().withModel(QIAN_WEN_MODEL).build())
                .build();
    }

    /**
     * 配置chatClient 的 deepSeek模型
     */
    @Bean
    public ChatClient deepSeekChatClient(@Qualifier("deepSeekChatModel") ChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .defaultOptions(ChatOptions.builder().model(DEEP_SEEK_MODEL).build())
                .build();
    }

    /**
     * 配置chatClient 的 qwen 模型
     */
    @Bean
    public ChatClient qwenChatClient(@Qualifier("qwenChatModel") ChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .defaultOptions(ChatOptions.builder().model(QIAN_WEN_MODEL).build())
                .build();
    }

}
