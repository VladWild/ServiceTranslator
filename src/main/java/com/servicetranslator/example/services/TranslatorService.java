package com.servicetranslator.example.services;

import com.servicetranslator.example.parsers.Parser;
import com.servicetranslator.example.processing.RequestWord;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("translatorService")
@Log4j
public class TranslatorService {
    private Parser parser;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    public TranslatorService(Parser parser){
        this.parser = parser;
    }

    public void wordProcessing(String text){
        Set<String> setWords = parser.getWords(text);
        log.debug("Множество слов: " + setWords.stream().reduce("", (a, e) -> a + e + ", "));
        log.debug("Количество слов - " + setWords.size());

        setWords.forEach(word -> executorService.submit(new RequestWord(word)));
    }
}
