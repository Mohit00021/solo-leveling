package com.mo.sololeveling.Gemini;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import static com.mo.sololeveling.Gemini.JsonStructure.*;


@HttpExchange("/v1beta/models/")
public interface GeminiInterface {
    @GetExchange
    ModelList getModels();

    @PostExchange("{model}:generateContent")
    GeminiResponse getCompletion(
            @PathVariable String model,
            @RequestBody GeminiRequest request);
}