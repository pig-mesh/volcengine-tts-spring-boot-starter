package io.github.pigmesh.ai.volcengine.tts.core;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pigmesh.ai.volcengine.tts.config.TtsProperties;
import io.github.pigmesh.ai.volcengine.tts.model.TtsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * VolcEngine TTS 服务
 *
 * @author lengleng
 * @date 2024/09/03
 */
@RequiredArgsConstructor
public class VolcengineTtsService {

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    private final TtsProperties ttsProperties;

    /**
     * 合成语音
     *
     * @param text 发短信
     * @return {@link String }
     * @throws IOException io异常
     */
    public String synthesizeVoice(String text) throws IOException {
        TtsRequest ttsRequest = new TtsRequest(text);
        ttsRequest.getApp().setAppid(ttsProperties.getAppId());
        ttsRequest.getApp().setCluster(ttsProperties.getCluster());
        ttsRequest.getApp().setToken(ttsProperties.getAccessToken());
        ttsRequest.getUser().setUid(UUID.randomUUID().toString());

        ttsRequest.getAudio().setEmotion(ttsProperties.getEmotion());
        ttsRequest.getAudio().setEncoding(ttsProperties.getEncoding());
        ttsRequest.getAudio().setPitch_ratio(ttsProperties.getPitch_ratio());
        ttsRequest.getAudio().setSpeed_ratio(ttsProperties.getSpeed_ratio());
        ttsRequest.getAudio().setVolume_ratio(ttsProperties.getVolume_ratio());
        ttsRequest.getAudio().setVoice_type(ttsProperties.getVoice_type());
        ttsRequest.getRequest().setReqid(UUID.randomUUID().toString());
        String jsonRequest = objectMapper.writeValueAsString(ttsRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer;" + ttsProperties.getAccessToken());
        HttpEntity<String> entity = new HttpEntity<>(jsonRequest, headers);
        String responseString = restTemplate.postForObject(ttsProperties.getApiUrl(), entity, String.class);
        Map<String, String> responseMap = objectMapper.readValue(responseString, Map.class);
        return responseMap.get("data");
    }
}
