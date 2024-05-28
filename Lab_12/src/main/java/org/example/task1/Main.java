package org.example.task1;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        MyUtilityClass.printCollection(integers); // output: [1, 2, 3, 4, 5]

        Collection<?> strings = List.of("ana", 1, true, "", "mere");
        MyUtilityClass.printCollection(strings);

        List<Boolean> booleans = List.of(true, false, true, false, true);
        {
            int result = MyUtilityClass.aggregate(booleans, 0, (acc, v) -> v ? acc + 1 : acc);
            System.out.println(result); // output: 3
        }
        {
            boolean result = MyUtilityClass.aggregate(booleans, true, (acc, v) -> acc & v);
            System.out.println(result); // output: false
        }

        record Person(String name) {}

        List<Person> persons = new ArrayList<>(){{
            add(new Person("Aurel"));
            add(new Person("Vali"));
        }};

        MyUtilityClass.duplicate(persons);
        MyUtilityClass.printCollection(persons);
    }
}
