import java.io.*;
import java.util.*;
import java.nio.file.*;

public class QuizCardIO {
    private ArrayList<QuizCard> cardList;

    public ArrayList<QuizCard> loadFromFile(File file) throws IOException {

        cardList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
            String line;
            while((line = reader.readLine()) != null) {
                makeCard(line);
            }
        } 
        return cardList;
    }

    private void makeCard(String lineToParse) {
        String[] result = lineToParse.split("/");
        
        if (result.length != 2) {
            System.out.println("Skipping invalid line: " + lineToParse);
            return;
        }
            
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }

    public void saveToFile(File file, List<QuizCard> cards) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (QuizCard card: cards) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
        }
    }
}