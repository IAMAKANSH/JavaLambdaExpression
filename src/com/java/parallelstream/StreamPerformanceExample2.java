package com.java.parallelstream;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamPerformanceExample2 {
    static  long tokenCount=50000;
    public static void main(String[] args) {

        int loop=20;
        long result=measurePerformance(StreamPerformanceExample2::sortSequentialStream,loop);
        System.out.println("Time taken to process sum in sequential :: "+result+ " in  msecs");
        result=measurePerformance(StreamPerformanceExample2::sortParallelStream,loop);
        System.out.println("Time taken to process sum in sequential :: "+result+ " in  msecs");

    }
    public static long measurePerformance(Supplier<Integer> supplier, int numberOfTimes){
        long startTime=System.currentTimeMillis();
        for(int i=0;i<numberOfTimes;i++)
        {
            supplier.get();
        }
        return System.currentTimeMillis()-startTime;
    }

    public static int sortSequentialStream()
    {
        List<RandomToken> randomTokens= LongStream.rangeClosed(0,tokenCount).mapToObj(value -> {
            return new RandomToken(value, ThreadLocalRandom.current().nextLong(tokenCount));
        }).collect(Collectors.toList());
        randomTokens.stream().sorted(Comparator.comparing(RandomToken::getToken));
        return  -1;
    }

    public static int sortParallelStream()
    {
        List<RandomToken> randomTokens= LongStream.rangeClosed(0,tokenCount).parallel().mapToObj(value -> {
            return new RandomToken(value, ThreadLocalRandom.current().nextLong(tokenCount));
        }).collect(Collectors.toList());
        randomTokens.stream().parallel().sorted(Comparator.comparing(RandomToken::getToken));
        return  -1;
    }
}
class RandomToken
{
    long id;
    long token;

    public RandomToken(long id, long token) {
        this.id = id;
        this.token = token;
    }

    @Override
    public String toString() {
        return "RandomToken{" +
                "id=" + id +
                ", token=" + token +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }
}
