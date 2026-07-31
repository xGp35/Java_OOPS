import java.util.*;

class MixForLoops {
    public static void main(String [] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";
        for (int i = 0; i <= nums.size(); i++) {
            output += nums.get(i) + " ";
            System.out.println(output);
        }
        
    }
}