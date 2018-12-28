package com.servicetranslator.example.parsers;

import java.util.Set;

public interface Parser {
    Set<String> getWords(String text);
}
