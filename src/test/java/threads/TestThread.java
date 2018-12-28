package threads;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(MockitoJUnitRunner.class)
public class TestThread {
    private static final int COUNT_OBJECT = 100;
    private static final int COUNT_THREAD = 2;

    @Test
    public void testThreadPull(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < COUNT_OBJECT; i++){
            executorService.submit(new MyRunnable(i));
        }
        executorService.shutdown();
    }

    static class MyRunnable implements Runnable{
        private int i;

        MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(i + " - поток начал выполняться");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Main{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++){
            executorService.submit(new TestThread.MyRunnable(i));
        }
        executorService.shutdown();
    }
}