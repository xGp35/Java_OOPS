import java.util.*;
import java.util.concurrent.*;
import java.time.LocalDateTime;
import java.time.format.*;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

public class ThreadSafeConcurrentReaders {
    public static void main(String[] args) {
        // CopyOnWriteArrayList is a reasonable choice when you have a List that is being read a lot,
        // but not changed very often.
        List<Chat> chatHistory = new CopyOnWriteArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        for(int i = 0 ; i < 5 ; i++) {
            pool.execute(() -> chatHistory.add(new Chat("Hi there!")));
            pool.execute(() -> System.out.println(chatHistory));
            pool.execute(() -> System.out.println(chatHistory));
        }
        pool.shutdown();
        // This will throw ConcurrentModificationException as we are modifying things
        // while they are being read. Solution is to use thread-safe Data Structures
        // like CopyOnWriteArrayList
    }
}

final class Chat {
    private final String message;
    private final LocalDateTime timestamp;

    public Chat(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    public String toString() {
        String time = timestamp.format(ofLocalizedTime(MEDIUM));
        return time + " " + message;
    }
}