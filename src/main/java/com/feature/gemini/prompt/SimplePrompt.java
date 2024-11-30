package com.feature.gemini.prompt;

import com.feature.gemini.configuration.VertexAiConfiguration;
import com.feature.gemini.property.VertexAiProperties;
import com.feature.gemini.service.ChatService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimplePrompt {

  public static void main(String[] args) {
    // replace values
    var vertexAiProperties = VertexAiProperties.builder()
            .projectId("{PROJECT_ID}")
            .location("{LOCATION}")
            .transport("REST")
            .modelOptions(VertexAiProperties.ModelOptions.builder()
                    .model("{MODEL}")
                    .maxOutputTokens(500)
                    .temperature(0.2f)
                    .topP(04.f)
                    .topK(5)
                    .build())
            .build();
    var genAIConfiguration = new VertexAiConfiguration();
    var chatService = new ChatService(genAIConfiguration.generativeModel(vertexAiProperties));
    var textPrompt = """
        What's a good name for a flower shop that specializes in selling bouquets of dried flowers?"
        """;
    var output = chatService.generateContent(textPrompt);
    log.info(output);
  }

}
