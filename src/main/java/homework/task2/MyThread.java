package homework.task2;

import java.util.concurrent.Callable;

public class MyThread implements Callable {
    private Integer result = 0;

    @Override
    public Object call() throws Exception {
        try {
            while (true) {
                Thread.sleep(2500);
                System.out.printf("%s Hello! \n", Thread.currentThread().getName());
                result++;
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.printf("%s stopped \n", Thread.currentThread().getName());
        }
        return this.result;
    }
}
