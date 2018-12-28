package parsers;

import com.servicetranslator.example.parsers.Parser;
import com.servicetranslator.example.parsers.SimpleParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestsParsers {

    @Test
    public void testSimpleParser(){
        Set<String> listWordsForOutput = new HashSet<>(Arrays.asList("привет", "мир", "слово", "привет", "пока"));

        String text = "привет мир слово привет пока";

        Parser parser = new SimpleParser();
        Set<String> arrayWord = parser.getWords(text);

        assertEquals(listWordsForOutput, arrayWord);
    }

}
