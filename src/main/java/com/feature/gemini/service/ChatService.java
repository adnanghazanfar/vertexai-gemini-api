package com.feature.gemini.service;

import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    final GenerativeModel generativeModel;

    public String generateContent(String textPrompt) {
        try {
            log.info("Generating content with prompt: {}.", textPrompt);
            var response = generativeModel.generateContent(textPrompt);
            var responseStr = ResponseHandler.getText(response);
            log.info("Generated response: {}.", responseStr);
            return responseStr;
        } catch (Exception ex) {
            log.error("Exception occurred while generating content.", ex);
            return "Something went wrong";
        }
    }

}
