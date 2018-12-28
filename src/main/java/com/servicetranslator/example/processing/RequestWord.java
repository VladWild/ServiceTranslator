package com.servicetranslator.example.processing;

import com.servicetranslator.example.data.ResponseWord;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RequestWord implements Runnable{
    private static final String URL = "https://translate.yandex.net";
    private static final String PATH = "/api/v1.5/tr.json/translate";
    private static final String KEY = "trnsl.1.1.20181227T101347Z.59ae4b99574d0fee.4d03b4acf277f3c7c2f5d8300038bcfd0b149e73";
    private static final String LANG_RUS_ENG = "ru-en";

    private String word;

    public RequestWord(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(URL + PATH)
                .queryParam("key", KEY)
                .queryParam("text", word)
                .queryParam("lang", LANG_RUS_ENG).build();

        HttpEntity<ResponseWord> entity = new HttpEntity<>(headers);

        ResponseEntity<ResponseWord> response = restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, entity, ResponseWord.class);

        ResponseWord responseWord = response.getBody();

        System.out.println(responseWord);
    }
}
