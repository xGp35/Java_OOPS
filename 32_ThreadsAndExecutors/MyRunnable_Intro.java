// This is the same class as the one present in RunTester
// I renamed it to MyRunnable_Intro so other programs don't come here looking for MyRunnable.
// Why you might ask? - Because I wanted one version and this to be a tutorial with excess comments
public class MyRunnable_Intro implements Runnable {
    @Override
    public void run() {
        System.out.println("You shouldn't be running this. Check your code");
        go();
    }
    // Runnable has only one method to implement - run()
    // This is where you put the JOB the thread is supposed to run.
    // This goes at the bootom of the new Stack

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println(Thread.currentThread().getName() + ": top o' the stack");
        Thread.dumpStack();
    }
    // dumpStack will output the current call stack, just like an Exceptions stack trace.
    // Using it here witl show us the current stack, but you shuold only use this for debugging.
    // Might slow real code down.
}