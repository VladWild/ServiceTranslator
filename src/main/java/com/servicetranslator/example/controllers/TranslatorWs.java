package com.servicetranslator.example.controllers;

import com.servicetranslator.example.services.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String greeting(@RequestParam(name="text",
            required=false,
            defaultValue="Текста нет") String text, Model model) {
        translatorService.hello();
        model.addAttribute("textInput", text);
        model.addAttribute("textOutput", text);
        return "main";
    }
}
