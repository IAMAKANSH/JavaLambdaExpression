package consumer;

import java.util.function.Consumer;

public class ConsumerExample1 {

    public static void main(String[] args) {

        //Consumer is a functional interface which accept an argument but doesn't return anything and mainly used for printing
        Consumer<String> stringConsumer=s -> System.out.println("FC Barcelona "+s);
        //accept method accept an argument and that can printed using consumer
        stringConsumer.accept("Lionel Messi");

    }
}
