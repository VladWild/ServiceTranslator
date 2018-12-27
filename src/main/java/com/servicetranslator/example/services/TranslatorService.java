package com.servicetranslator.example.services;

import org.springframework.stereotype.Service;

@Service("translatorService")
public class TranslatorService {
    public void hello(){
        System.out.println("Я в TranslatorService");
    }
}
