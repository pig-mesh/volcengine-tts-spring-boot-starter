# Volcengine TTS Spring Boot Starter

[![Maven Central](https://img.shields.io/maven-central/v/io.github.pig-mesh.ai/volcengine-tts-spring-boot-starter.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:io.github.pig-mesh.ai%20a:volcengine-tts-spring-boot-starter)

`volcengine-tts-spring-boot-starter` 是一个用于简化火山引擎语音合成（TTS）服务集成的 Spring Boot Starter。通过简单的配置和代码调用，开发者可以快速将 TTS 功能集成到自己的 Spring Boot 应用中。

## 特性

- 简单集成：基于 Spring Boot 自动配置，快速集成 TTS 功能。
- 高效调用：支持通过配置和代码调用实现语音合成。
- 灵活配置：支持自定义 TTS 服务的 `access-token`、`cluster` 和 `app-id`。

## 快速开始

### 1. 引入依赖

在你的 `pom.xml` 文件中添加以下依赖：

```xml
<dependency>
    <groupId>io.github.pig-mesh.ai</groupId>
    <artifactId>volcengine-tts-spring-boot-starter</artifactId>
    <version>0.0.1</version>
</dependency>
```

### 2. 配置文件

在 `application.yml` 或 `application.properties` 中添加以下配置：

```yaml
tts:
  access-token: XX
  cluster: volcano_tts
  app-id: XX
```

### 3. 使用服务

通过 `@Autowired` 注入 `VolcengineTtsService`，并在你的代码中使用该服务进行语音合成：

```java
import io.github.pigmesh.volcengine.tts.VolcengineTtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TtsService {

    @Autowired
    private VolcengineTtsService volcengineTtsService;

    public void synthesizeVoice(String text) {
        volcengineTtsService.synthesizeVoice(text);
    }
}
```

## 配置项说明

| 配置项         | 说明                         |
| -------------- | ---------------------------- |
| `tts.access-token` | 火山引擎 API 的访问令牌          |
| `tts.cluster`      | 使用的 TTS 集群名称            |
| `tts.app-id`       | 火山引擎应用的 ID             |

## 许可证

`volcengine-tts-spring-boot-starter` 使用 [MIT 许可证](LICENSE) 进行开源。

## 贡献

欢迎提交 issue 或 pull request 来贡献代码和改进文档。
