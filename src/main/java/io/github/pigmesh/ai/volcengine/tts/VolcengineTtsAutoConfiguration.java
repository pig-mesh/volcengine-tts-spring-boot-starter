package io.github.pigmesh.ai.volcengine.tts;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pigmesh.ai.volcengine.tts.config.TtsProperties;
import io.github.pigmesh.ai.volcengine.tts.core.VolcengineTtsService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author lengleng
 * @date 2024/9/3
 */
@AutoConfiguration
@EnableConfigurationProperties(TtsProperties.class)
public class VolcengineTtsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public VolcengineTtsService volcengineTtsService(
            RestTemplate restTemplate,
            ObjectMapper objectMapper,
            TtsProperties ttsProperties) {
        return new VolcengineTtsService(restTemplate, objectMapper, ttsProperties);
    }
}
