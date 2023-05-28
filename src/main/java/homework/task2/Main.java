package homework.task2;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        out.println("Create threads...");
        ThreadGroup threadGroup = new ThreadGroup("mainGroup");

//        MyThread thread1 = new MyThread();
//        MyThread thread2 = new MyThread();
//        MyThread thread3 = new MyThread();
//        MyThread thread4 = new MyThread();

//        thread1.setName("I'm thread № 1");
//        thread2.setName("I'm thread № 2");
//        thread3.setName("I'm thread № 3");
//        thread4.setName("I'm thread № 4");

        FutureTask<Integer> task1 = new FutureTask<>(new MyThread());
        FutureTask<Integer> task2 = new FutureTask<>(new MyThread());
        FutureTask<Integer> task3 = new FutureTask<>(new MyThread());
        FutureTask<Integer> task4 = new FutureTask<>(new MyThread());

        new Thread(task1).setName("I'm thread № 1");
        new Thread(task2).setName("I'm thread № 2");
        new Thread(task3).setName("I'm thread № 3");
        new Thread(task4).setName("I'm thread № 4");


        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        new Thread(task4).start();



        Thread.sleep(15000);
       // out.println("Oll thread stopped");

        out.println(task1.get());
    }
}
