package com.feature.gemini.controller;

import com.feature.gemini.model.ChatReqsponse;
import com.feature.gemini.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatController {

  final ChatService chatService;

  @PostMapping(value = "/chat", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ChatReqsponse> generateContent(@RequestBody String prompt) {
    var stopWatch = new StopWatch();
    stopWatch.start();
    var responseString = chatService.generateContent(prompt);
    stopWatch.stop();
    log.info("Response was generated in {}s.", stopWatch.getTotalTimeSeconds());
    return ResponseEntity.ok(ChatReqsponse.builder()
        .response(responseString)
        .timeTaken(stopWatch.getTotalTimeSeconds()).build());
  }


}
