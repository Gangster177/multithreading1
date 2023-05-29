package homework.task2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        out.println("Create threads...");

        Callable<Integer> myThread1 = new MyThread(5, "thread № 1");
        Callable<Integer> myThread2 = new MyThread(2, "thread № 2");
        Callable<Integer> myThread3 = new MyThread(3, "thread № 3");
        Callable<Integer> myThread4 = new MyThread(4, "thread № 4");

        List<Callable<Integer>> tasks = Arrays.asList(myThread1, myThread2, myThread3, myThread4);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futureTask = threadPool.invokeAll(tasks);

        for (var ft : futureTask) {
            int resultOfTask = ft.get();
            System.out.printf("Result of thread => %d \n", resultOfTask);
        }
//TODO Проведите аналогичную операцию, но с получением результата от одной из задач
//        out.println(threadPool.invokeAny(tasks));

        out.println("Oll thread stopped");
        threadPool.shutdown();
    }
}
