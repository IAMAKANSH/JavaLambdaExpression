package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableExample {

    //to have 5000 integer array
    public static  int[] arr=IntStream.rangeClosed(0,5000).toArray();
    public  static  int sum=IntStream.rangeClosed(0,5000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //Dividing the sum into 2 callable
        Callable callable1=()->{
            int sum=0;
            for (int i=0;i<arr.length/2;i++)
            {
                sum +=arr[i];
            }
            return  sum;
        };

        Callable callable2=()->{
            int sum=0;
            for (int i=arr.length/2;i<arr.length;i++)
            {
                sum +=arr[i];
            }
            return  sum;
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        List<Callable<Integer>> callables= Arrays.asList(callable1,callable2);
        List<Future<Integer>> futures=executorService.invokeAll(callables);
        int k=0;
        int summation=0;
        for (Future<Integer> future:futures)
        {
            summation +=future.get();
            System.out.println("Sum of "+ ++k +"is :"+summation);
        }
        System.out.println("Total is "+summation);
        System.out.println("Sum fom stream "+sum);
        executorService.shutdown();
    }
}
