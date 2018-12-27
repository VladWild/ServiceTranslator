package com.servicetranslator.example.parsers;

import java.util.List;

public interface Parser {
    List<String> getWords(String text);
}
