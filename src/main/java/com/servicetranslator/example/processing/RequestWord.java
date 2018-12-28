package com.servicetranslator.example.processing;

import com.servicetranslator.example.data.ResponseWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Slf4j
public class RequestWord {
    private static final String URL = "https://translate.yandex.net";
    private static final String PATH = "/api/v1.5/tr.json/translate";
    private static final String KEY = "trnsl.1.1.20181227T101347Z.59ae4b99574d0fee.4d03b4acf277f3c7c2f5d8300038bcfd0b149e73";
    private static final String LANG_RUS_ENG = "ru-en";

    private RestTemplate restTemplate = new RestTemplate();

    public String getNewWord(String word) {
        HttpHeaders headers = new HttpHeaders();

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(URL + PATH)
                .queryParam("key", KEY)
                .queryParam("text", word)
                .queryParam("lang", LANG_RUS_ENG).build();

        HttpEntity<ResponseWord> entity = new HttpEntity<>(headers);

        ResponseEntity<ResponseWord> response = restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, entity, ResponseWord.class);

        ResponseWord responseWord = response.getBody();
        log.info("Слово: " + word + " | Перевод: " + Arrays.stream(responseWord.getText()).reduce("", (a, e) -> a + e + " "));

        return Arrays.stream(responseWord.getText()).reduce("", (a, e) -> a + e + " ");
    }
}
