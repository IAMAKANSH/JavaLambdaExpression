package com.java.chauhantest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Test4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> stringList = new ArrayList<>();
        for (int i=0;i<100000000;i++)
        {
            stringList.add(i);
        }

        Callable<String> callable=() -> {
            Long start=System.currentTimeMillis();
            Thread.sleep(5000);
            for (int i=0;i<stringList.size()/2;i++)
            {
                System.out.println("Inside Thread A-callable"+i);
            }
            Long endTime=System.currentTimeMillis();
            System.out.println("Total time consumeed"+(endTime-start));
            return "ABC";
        };

        Callable<String> callable2=() -> {
            Long start=System.currentTimeMillis();
            Thread.sleep(5000);
            for (int i=stringList.size()/2;i<stringList.size();i++)
            {
                System.out.println("Inside Thread A-callable2"+i);
            }
            Long endTime=System.currentTimeMillis();
            System.out.println("Total time consumeed"+(endTime-start));
            return "ABC";
        };

        ExecutorService service= Executors.newFixedThreadPool(1);
        List<Callable<String>> listCallable=Arrays.asList(callable,callable2);
        List<Future<String>> future=service.invokeAll(listCallable);
        for (Future<String> future1:future)
            System.out.println(future1.get());
        service.shutdown();
        /**
         * application property-->intention
         * application ynml->>intention
         *
         *   hashcode--->>>
         *   Arrays.asList(1,2,3,4,5,6,7)
         *   hascodekey+value->Akansh12312
         *                     Akshayhashcode-->tree->
         *         Map.put(key,value)--->hashcode       Memory  @hashcode-> Akansh,
         *         equals ==
         *
         */


        






    }
}
