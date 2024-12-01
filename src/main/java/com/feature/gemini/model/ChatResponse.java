package com.feature.gemini.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(
        name = "Chat Response",
        description = "Chat Response"
)
@Builder
@Data
public class ChatResponse {

    @Schema(
            name = "response",
            description = "Generated content"
    )
    private String response;

    @Schema(
            name = "timeTaken",
            description = "Time taken by gemini to genated content"
    )
    private double timeTaken;

}
