package com.servicetranslator.example.parsers;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("textParser")
public class SimpleParser implements Parser {
    private static final String SEPARATOR = " ";

    @Override
    public List<String> getWords(String text) {
        return Arrays.stream(text.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
