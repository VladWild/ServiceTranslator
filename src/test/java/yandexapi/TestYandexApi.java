package yandexapi;

import com.servicetranslator.example.data.ResponseWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestYandexApi {
    private static final String FORMAT_URL = "https://translate.yandex.net%s?key=%s&text=%s&lang=%s";
    private static final String URL = "https://translate.yandex.net";
    private static final String PATH = "/api/v1.5/tr.json/translate";
    private static final String KEY = "trnsl.1.1.20181227T101347Z.59ae4b99574d0fee.4d03b4acf277f3c7c2f5d8300038bcfd0b149e73";
    private static final String LANG_RUS_ENG = "ru-en";

    @Test
    public void testWordYandexServiceWithJava() throws IOException {
        String rusWord = "привет";
        String engWord = "hi";

        final String URI = String.format(FORMAT_URL,
                PATH, KEY, rusWord, LANG_RUS_ENG);

        URL obj = new URL(URI);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream());
             BufferedReader in = new BufferedReader(reader)){
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        System.out.println(response.toString());
    }

    @Test
    public void testWordYandexServiceWithSpring() throws IOException {
        String rusWord = "цена";
        String[] engWord = new String[]{"price"};

        final String URI = String.format(FORMAT_URL,
                PATH, KEY, rusWord, LANG_RUS_ENG);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(URL + PATH)
                .queryParam("key", KEY)
                .queryParam("text", rusWord)
                .queryParam("lang", LANG_RUS_ENG).build();

        HttpEntity<ResponseWord> entity = new HttpEntity<>(headers);

        ResponseEntity<ResponseWord> response = restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, entity, ResponseWord.class);

        ResponseWord responseWord = response.getBody();

        assert responseWord != null;
        assertArrayEquals(responseWord.getText(), engWord);
    }


}
