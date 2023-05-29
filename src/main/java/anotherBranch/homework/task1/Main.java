package anotherBranch.homework.task1;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        out.println("Create threads...");
        ThreadGroup threadGroup = new ThreadGroup("mainGroup");

        Thread thread1 = new Thread(threadGroup, new MyThread());
        Thread thread2 = new Thread(threadGroup, new MyThread());
        Thread thread3 = new Thread(threadGroup, new MyThread());
        Thread thread4 = new Thread(threadGroup, new MyThread());

        thread1.setName("I'm thread № 1");
        thread2.setName("I'm thread № 2");
        thread3.setName("I'm thread № 3");
        thread4.setName("I'm thread № 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);
        out.println("Oll thread stopped");
        threadGroup.interrupt();
    }
}
