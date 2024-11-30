package com.feature.gemini.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChatReqsponse {

  private String response;
  private double timeTaken;

}
