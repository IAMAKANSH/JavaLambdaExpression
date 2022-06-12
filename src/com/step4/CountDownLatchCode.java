package step4;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CountDownLatchCode {

    public static int[] array= IntStream.rangeClosed(0,5000).toArray();
    public static int total=IntStream.rangeClosed(0,5000).sum();
    final static CountDownLatch COUNT_DOWN_LATCH=new CountDownLatch(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable1= () -> {
            int sum=0;
            for (int i=0;i<array.length/2;i++)
            {
                sum +=array[i];
            }
            COUNT_DOWN_LATCH.countDown();
            return sum;
        };


        Callable<Integer> callable2= () -> {
            int sum=0;
            for (int i=array.length/2;i<array.length;i++)
            {
                sum +=array[i];
            }
            COUNT_DOWN_LATCH.countDown();
            return sum;
        };


        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<Integer> sum1=executorService.submit(callable1);
        Future<Integer> sum2=executorService.submit(callable2);
        System.out.println("Count down latch count before calling the await "+COUNT_DOWN_LATCH.getCount());
        COUNT_DOWN_LATCH.await();
        System.out.println("Count down latch count after calling the await "+COUNT_DOWN_LATCH.getCount());
        System.out.println("Sum 1 :"+sum1);
        System.out.println("Sum 2 : "+sum2);
        System.out.println("Sum1 + sum 2 :"+(sum1. get()+sum2.get()));
        System.out.println("Verified Sum :"+total);
        executorService.shutdown();
    }
}
