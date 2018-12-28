package com.servicetranslator.example.controllers;

import com.servicetranslator.example.services.TranslatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranslatorWs {
    private TranslatorService translatorService;

    public TranslatorWs(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @GetMapping("/")
    public String translate(@RequestParam(name = "text",  required = false,
             defaultValue = "Текста нет") String text) {
        List<String> words = translatorService.wordProcessing(text);
        return words.stream().reduce("", (a, e) -> a + e + " ");
    }
}
