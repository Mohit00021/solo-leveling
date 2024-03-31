package com.mo.sololeveling.controller;

import com.mo.sololeveling.service.GeminiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor

public class GeminiTestController {

    private final GeminiService geminiService;

    @GetMapping("/askGemini")
    public ResponseEntity<String> askGeminiAi(@RequestParam String promptForGemini){
        String geminiRes = geminiService.getCompletion(promptForGemini);

        return ResponseEntity.ok().body(geminiRes);
    }
}