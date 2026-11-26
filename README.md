# spring-ai-alibaba

基于 Spring AI Alibaba 的学习项目。

## 模块

- `saa-hello-world`：接入 DashScope（通义千问）的最小对话服务。

## 运行前配置

大模型密钥通过环境变量注入，不写入仓库：

```bash
# Linux / macOS
export DASHSCOPE_API_KEY=你的密钥

# Windows PowerShell
$env:DASHSCOPE_API_KEY="你的密钥"
```

如在 IntelliJ IDEA 中运行，可在 Run Configuration 的 Environment variables 里填写同样的变量。

## 启动

```bash
mvn -pl saa-hello-world spring-boot:run
```

服务默认监听 `8080` 端口。
