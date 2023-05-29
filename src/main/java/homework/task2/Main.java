package homework.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        out.println("Create threads...");

        Callable<Integer> myThread1 = new MyThread(5, "One");
        Callable<Integer> myThread2 = new MyThread(6, "Two");
        Callable<Integer> myThread3 = new MyThread(3, "Three");
        Callable<Integer> myThread4 = new MyThread(4, "Four");

        List<Callable<Integer>> tasks = Arrays.asList(myThread1,myThread2,myThread3,myThread4);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futureTask = threadPool.invokeAll(tasks);

        out.println("Oll thread stopped");
        threadPool.shutdown();
        for(Future<Integer> ft : futureTask){
            var resultOfTask = ft.get();
            System.out.printf("Result of : .... => %d \n", resultOfTask);
        }
    }
}
