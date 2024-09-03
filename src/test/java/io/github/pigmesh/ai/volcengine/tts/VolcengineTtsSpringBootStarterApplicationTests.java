package io.github.pigmesh.ai.volcengine.tts;

import io.github.pigmesh.ai.volcengine.tts.core.VolcengineTtsService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = VolcengineTtsAutoConfiguration.class)
class VolcengineTtsSpringBootStarterApplicationTests {

    @Autowired
    private VolcengineTtsService volcengineTtsService;

    @Test
    @SneakyThrows
    void contextLoads() {
        volcengineTtsService.synthesizeVoice("stabilityai/stable-diffusion-xl-base-1.0\"");
    }

}
