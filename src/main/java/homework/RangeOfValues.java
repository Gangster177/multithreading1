package homework;

import java.util.*;
import java.util.concurrent.*;

public class RangeOfValues {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String[] texts = new String[25];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("aab", 30_000);
        }

        long startTs = System.currentTimeMillis(); // start time
        List<Callable<Integer>> threads = new ArrayList<>();
        for (String text : texts) {
            threads.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {


                    int maxSize = 0;
                    for (int i = 0; i < text.length(); i++) {
                        for (int j = 0; j < text.length(); j++) {
                            if (i >= j) {
                                continue;
                            }
                            boolean bFound = false;
                            for (int k = i; k < j; k++) {
                                if (text.charAt(k) == 'b') {
                                    bFound = true;
                                    break;
                                }
                            }
                            if (!bFound && maxSize < j - i) {
                                maxSize = j - i;
                            }
                        }
                    }
                    //System.out.println(text.substring(0, 100) + " -> " + maxSize);
                    return maxSize;
                }
            });
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(threads.size());
        List<Future<Integer>> futureTask = threadPool.invokeAll(threads);
        List<Integer> result = new ArrayList<>();
        for (var ft : futureTask) {
            //int resultOfTask = ft.get();
            //System.out.printf("Result of thread => %d \n", resultOfTask);
            result.add(ft.get());
        }
        System.out.println("Max result: " + Collections.max(result));
        threadPool.shutdown();
        long endTs = System.currentTimeMillis(); // end time
        System.out.println("Time: " + (endTs - startTs) + "ms");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}
