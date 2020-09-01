package com.udemy;

import org.openqa.selenium.json.JsonOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class TestMain {

    public static void main(String[] args) {
        Supplier<Double> random = Math::random;

        System.out.println(random.get());

        Consumer<Double> c1 = System.out::println;
        c1.accept(random.get());


        List<String> list = new ArrayList<>();
        list.add("Pradeep");
        list.add("Christhuraja");

        Consumer<String> c2 = System.out::println;

        //Consumer has No return type - we cannot use it
        Consumer<String> c3 = String::toUpperCase;

        list.forEach(c2);

        list.forEach( s -> {
            System.out.println(s.toUpperCase());
        });


        Consumer<String> dbConsumer = (s) -> {
            System.out.println("I am writing to DB ::" +s);
        };

        Consumer<String> loggingConsumer = (s) -> {
            System.out.println("I am writing to Log ::" +s);
        };

        Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);


        BiConsumer<String, Integer> biConsumer = (s, i) -> {
            System.out.println("My Name is ::" + s );
            System.out.println("My Age is ::" + i );
        };


        Map<String, Consumer<String>> map = new HashMap<>();

        map.put ("db", dbConsumer);
        map.put("log", loggingConsumer);
        map.put("dbLog", dbLogConsumer);

        //list.forEach(dbConsumer.andThen(loggingConsumer));

        list.forEach(map.get("dbLog"));

        biConsumer.accept("Pradeep", 30);


        map.forEach((k,v) ->
        {
            System.out.println("Key is ::"+k);
        });

        Predicate<Integer> isGT2 = (n) -> n > 2;
        Predicate<Integer> isLT10 = (n) -> n < 10;

        System.out.println(
                //isGT2.test(5)
                //isLT10.test(21)
                //isGT2.and(isLT10).test(1)
                isGT2.negate().test(1)
        );


        Function<String,Integer> srtLen = String::length;
        Function<Integer, Integer> square = (i) -> i*i;
        Function<Integer,Integer> plus2 = (i) -> i+2;

        System.out.println(
                srtLen.andThen(square).apply("Pradeep")
        );

        System.out.println(
                plus2.andThen(square).apply(8)
        );

        System.out.println(
                plus2.compose(square).apply(8)
        );
    }
}
