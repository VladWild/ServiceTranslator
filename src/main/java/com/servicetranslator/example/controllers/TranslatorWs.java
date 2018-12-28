package com.servicetranslator.example.controllers;

import com.servicetranslator.example.services.TranslatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslatorWs {
    private TranslatorService translatorService;

    public TranslatorWs(TranslatorService translatorService){
        this.translatorService = translatorService;
    }

    @GetMapping("/")
    public String translate(@RequestParam(name="text",
            required=false,
            defaultValue="Текста нет") String text,
                           Model model) {
        translatorService.wordProcessing(text);
        model.addAttribute("textInput", text);
        return "main";
    }
}
