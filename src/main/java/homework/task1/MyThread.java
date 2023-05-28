package homework.task1;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.printf("%s Hello! \n", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.printf("%s stopped \n", Thread.currentThread().getName());
        }
    }
}
