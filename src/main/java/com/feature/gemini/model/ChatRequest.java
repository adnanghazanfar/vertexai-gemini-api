package com.feature.gemini.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChatRequest {

  @NotNull
  @Size(min = 10, max = 1000)
  private String prompt;

}
