import java.util.concurrent.*;

class ExecutorTestDrive {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(()-> System.out.println("top o' the stack"));
        // As the run function that we implement doesn't take any args, we can do ()->

        System.out.println("back in main");
        executor.shutdown();
    }
}