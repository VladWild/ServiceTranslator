package com.servicetranslator.example.services;

import com.servicetranslator.example.parsers.Parser;
import org.springframework.stereotype.Service;

@Service("translatorService")
public class TranslatorService {
    private Parser parser;

    public TranslatorService(Parser parser){
        this.parser = parser;
    }

    public void wordProcessing(String text){
        System.out.println("Я в TranslatorService");
    }
}
