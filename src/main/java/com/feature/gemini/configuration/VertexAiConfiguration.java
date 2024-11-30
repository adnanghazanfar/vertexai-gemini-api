package com.feature.gemini.configuration;

import com.feature.gemini.property.VertexAiProperties;
import com.google.cloud.vertexai.Transport;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.api.SafetySetting.HarmBlockThreshold;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@EnableConfigurationProperties(VertexAiProperties.class)
@Configuration
public class VertexAiConfiguration {

  @Bean
  public GenerativeModel generativeModel(VertexAiProperties vertexAiProperties) {
    var vertexAI = new VertexAI.Builder()
            .setProjectId(vertexAiProperties.getProjectId())
            .setLocation(vertexAiProperties.getLocation())
            .setTransport(Transport.valueOf(vertexAiProperties.getTransport()))
            .build();

    var generationConfig = GenerationConfig.newBuilder()
        .setMaxOutputTokens(vertexAiProperties.getModelOptions().getMaxOutputTokens())
        .setTemperature(vertexAiProperties.getModelOptions().getTemperature())
        .setTopP(vertexAiProperties.getModelOptions().getTopP())
        .setTopK(vertexAiProperties.getModelOptions().getTopK())
        .build();

    return new GenerativeModel.Builder()
        .setModelName(vertexAiProperties.getModelOptions().getModel())
        .setGenerationConfig(generationConfig)
        .setSafetySettings(List.of(
                SafetySetting.newBuilder()
                        .setCategory(HarmCategory.HARM_CATEGORY_HATE_SPEECH)
                        .setThreshold(HarmBlockThreshold.BLOCK_MEDIUM_AND_ABOVE)
                        .build(),
                SafetySetting.newBuilder()
                        .setCategory(HarmCategory.HARM_CATEGORY_DANGEROUS_CONTENT)
                        .setThreshold(HarmBlockThreshold.BLOCK_MEDIUM_AND_ABOVE)
                        .build(),
                SafetySetting.newBuilder()
                        .setCategory(HarmCategory.HARM_CATEGORY_SEXUALLY_EXPLICIT)
                        .setThreshold(HarmBlockThreshold.BLOCK_MEDIUM_AND_ABOVE)
                        .build()
        ))
        .setVertexAi(vertexAI)
        .build();
  }

}
