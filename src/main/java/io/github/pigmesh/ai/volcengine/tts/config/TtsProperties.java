package io.github.pigmesh.ai.volcengine.tts.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tts")
public class TtsProperties {

    private String apiUrl = "https://openspeech.bytedance.com/api/v1/tts";
    private String accessToken;
    private String appId = "4456569928";
    private String cluster = "volcano_tts";
    private String uid = "388808087185088";

    private String voice_type = "BV002";
    private String encoding = "mp3";
    private float speed_ratio = 1;
    private float volume_ratio = 1;
    private float pitch_ratio = 1;
    private String emotion = "happy";

}
