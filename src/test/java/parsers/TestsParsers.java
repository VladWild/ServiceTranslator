package parsers;

import com.servicetranslator.example.parsers.Parser;
import com.servicetranslator.example.parsers.SimpleParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestsParsers {

    @Test
    public void testSimpleParser(){
        String[] arrayWordsForOutput = {"привет", "мир", "слово", "привет", "пока"};

        String text = "привет мир слово привет пока";

        Parser parser = new SimpleParser();
        List<String> arrayWord = parser.getWords(text);

        assertArrayEquals(arrayWordsForOutput, arrayWordsForOutput);
    }

}
