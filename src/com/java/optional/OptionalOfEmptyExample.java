package com.java.optional;

import java.util.Optional;

public class OptionalOfEmptyExample {

    public static void main(String[] args) {

        Optional<String> optionalString=Optional.of("Hello World");
        System.out.println(optionalString);
        System.out.println(getWords());
    }
    public static  Optional<String> getWords()
    {
        String[] words=new String[10];
        words[0]="Akansh";
        Optional<String> optionalS=Optional.ofNullable(words[0]);
        if(optionalS.isPresent())
            return optionalS;
        else
            return Optional.empty();
    }
}
