import java.util.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class QuizCardIOTest {

    @Test
    void testSaveAndLoadCards() throws IOException {
        QuizCardIO io = new QuizCardIO();

        List<QuizCard> original = new ArrayList<>();

        original.add(new QuizCard("Q1", "A1"));
        original.add(new QuizCard("Q2", "A2"));

        File tempFile = File.createTempFile("quiz", ".txt");

        io.saveToFile(tempFile, original);

        List<QuizCard> loaded = io.loadFromFile(tempFile);
        tempFile.deleteOnExit();

        assertEquals(2, loaded.size());
        
        assertEquals("Q1", loaded.get(0).getQuestion());
        assertEquals("A1", loaded.get(0).getAnswer());

        assertEquals("Q2", loaded.get(1).getQuestion());
        assertEquals("A2", loaded.get(1).getAnswer());
    }
}
