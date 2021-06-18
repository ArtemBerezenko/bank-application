package com.practice.bankapp.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MainClass {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 2, 3);
        Stream<Integer> count = ints.stream();
        count.anyMatch(w -> w.equals(3));
        List<String> collect = count.map(Object::toString).collect(toList());
        String string = args[0];
    }
}
