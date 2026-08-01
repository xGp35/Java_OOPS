import java.io.*;
import java.nio.file.*;

class ReadAFileStreamsAPI {
    public static void main(String[] args) {
        try {
            Files.lines(Path.of("MyText.txt"))
                 .forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}