package com.zixi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 流式输出示例
 * 流式输出（SSE）：Server-Sent-Event（服务器发送事件），指将模型的响应逐步输出，生成一点返回一点，允许服务器将响应内容分批次实时传输给客户端，
 * 适用于大模型响应慢的场景，为用户提供更好的体验。
 * SSE:是一种轻量级的单向通信协议，允许服务器可以持续的推送数据片段（如逐词或逐句）到前端的web技术，通过单向的http长连接，使服务器可以向浏览器推送实时更新。
 *      核心思想：客户端发起一次请求，服务器保持这个长连接打开并在有新数据时，通过这个连接发送给客户端，与传统的请求一次响应一次关闭连接有本质区别。
 *      下一代的SSE是 Streamable HTTP,注意SSE与websocket的区别，SSE是单向的，而websocket是双向的。
 */
@SpringBootApplication
public class SaaStreamOutputApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaaStreamOutputApplication.class, args);
        System.out.println("+----------------------------------------------------+ ");
        System.out.println("启动状态：启动成功");
        System.out.println("+----------------------------------------------------+ ");
    }
}
