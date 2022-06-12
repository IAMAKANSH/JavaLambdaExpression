package com.step5;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinExample extends RecursiveAction {

    public static  long total=0;
    public static final int CALCULATE_SUM_THRESHOLD=5;

    private List<Long> data;

    public ForkJoinExample(List<Long> data)
    {
        this.data=data;
    }

    @Override
    protected void compute() {
        if (data.size()<=CALCULATE_SUM_THRESHOLD)
        {
            long sum=computeSumDirectly();
            System.out.println("Sum of :"+data.toString()+ " is: "+ sum);
        }
        else {

            int mid=data.size()/2;
            ForkJoinExample forkJoinFirst=new ForkJoinExample(data.subList(0,mid));
            ForkJoinExample forkJoinSecond=new ForkJoinExample(data.subList(mid,data.size()));

            forkJoinFirst.fork(); //queuing the first subtask
            forkJoinSecond.compute();
            forkJoinFirst.join();
        }
    }

    private long computeSumDirectly() {
        long sum=0;
        for (Long l :data)
        {
            sum +=l;
        }
        total=total+sum;
        return sum;
    }

    public static void main(String[] args) {
        int end=5000;

        List<Long> list= LongStream.rangeClosed(0,end).boxed().collect(Collectors.toList());

        ForkJoinPool forkJoinPool=new ForkJoinPool();

        System.out.println("Pool Parellelism: "+forkJoinPool.getParallelism());

        ForkJoinExample forkJoinExample=new ForkJoinExample(list);
        forkJoinPool.invoke(forkJoinExample);
        System.out.println("Total is :"+total+ " and correct sum calculated using  stream is : "+
                LongStream.rangeClosed(0,end).sum());

    }
}
