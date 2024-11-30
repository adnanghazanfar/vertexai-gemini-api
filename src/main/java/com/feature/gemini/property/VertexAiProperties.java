package com.feature.gemini.property;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@Data
@ConfigurationProperties(prefix = "gemini")
public class VertexAiProperties {

    String projectId;
    String location;
    String transport;
    ModelOptions modelOptions;

    @Builder
    @Data
    public static class ModelOptions {
        String model;
        int maxOutputTokens;
        float temperature;
        float topP;
        int topK;
    }
}
