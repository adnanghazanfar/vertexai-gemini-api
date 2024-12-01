package com.feature.gemini.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Chat",
        description = "Chat input"
)
@Data
public class ChatRequest {

    @NotNull
    @Size(min = 10, max = 1000)
    @Schema(
            description = "Prompt", example = "Tell me a joke ?"
    )
    private String prompt;

}
