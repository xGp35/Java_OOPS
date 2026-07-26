import java.util.*;
import java.util.stream.*;

class TestStream{
    public static void main(String[] args) {

        List<String>  strings = List.of("I", "am", "a", "list", "of", "Strings");
        Stream<String> stream = strings.stream();
        // We can call this method to get a stream of these strings.

        Stream<String> limited = stream.limit(4);
        System.out.println(limited);
        // limit returns another string. So, it is an intermediate operation.
        // These are just instructions to be done, but don't actually perform 
        // the opertion on their own

        long result = limited.count();
        System.out.println("result = " + result);

        List<String> result_list = strings.stream()
                                          .sorted((s1,s2) -> s1.compareToIgnoreCase(s2))
                                          .skip(2)
                                          .limit(4)
                                          .collect(Collectors.toList());

        System.out.println("result_list = " + result_list);
    }
}