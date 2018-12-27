package com.servicetranslator.example.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseWord {
    private int code;
    private String lang;
    private String[] text;
}
