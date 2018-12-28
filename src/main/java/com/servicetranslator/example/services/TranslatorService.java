package com.servicetranslator.example.services;

import com.servicetranslator.example.parsers.Parser;
import com.servicetranslator.example.processing.RequestWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("translatorService")
@Slf4j
public class TranslatorService {
    private Parser parser;
    private RequestWord requestWord = new RequestWord();

    public TranslatorService(Parser parser){
        this.parser = parser;
    }

    public List<String> wordProcessing(String text){
        Set<String> setWords = parser.getWords(text);
        log.debug("Множество слов: " + setWords.stream().reduce("", (a, e) -> a + e + ", "));
        log.debug("Количество слов - " + setWords.size());

        return setWords.parallelStream()
                .map(requestWord::getNewWord)
                .collect(Collectors.toList());
    }
}
