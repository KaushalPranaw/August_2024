package Company.Walmart;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(5);
        for(int i=1;i<=10;i++){
            final int num=i;
            executor.schedule(()-> {
                System.out.println(num);
            }, i-1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.SECONDS); // Wait until all tasks are completed

    }
}
