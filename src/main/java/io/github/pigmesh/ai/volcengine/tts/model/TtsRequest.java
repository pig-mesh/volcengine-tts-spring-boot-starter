package io.github.pigmesh.ai.volcengine.tts.model;

import lombok.Data;

/**
 * tts 请求
 *
 * @author lengleng
 * @date 2024/09/03
 */
@Data
public class TtsRequest {

    private App app = new App();
    private User user = new User();
    private Audio audio = new Audio();
    private Request request = new Request();

    public TtsRequest(String text) {
        this.request.text = text;
    }

    // Getters and Setters

    @Data
    public class App {
        private String appid;
        private String token;
        private String cluster;

        // Getters and Setters
    }

    @Data
    public class User {
        private String uid;
    }

    @Data
    public class Audio {
        private String voice_type;
        private String encoding;
        private float speed_ratio;
        private float volume_ratio;
        private float pitch_ratio;
        private String emotion;
    }

    /**
     * 请求
     *
     * @author lengleng
     * @date 2024/09/03
     */
    @Data
    public class Request {
        private String reqid;
        private String text;
        private String text_type = "plain";
        private String operation = "query";
    }
}
