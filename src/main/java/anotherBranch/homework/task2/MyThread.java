package anotherBranch.homework.task2;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    private Integer result = 0;
    private String name;
    private final int CYCLE;

    public MyThread(int CYCLE, String name) {
        this.CYCLE = CYCLE;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        for (int x = 0; x < CYCLE; x++) {
            Thread.sleep(2000);
            System.out.printf("%s Hello! \n", name);
            result++;
        }
        return result;
    }
}

