package org.example.task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilityClassTest {

    @Test
    void testAggregateValidInput(){
        List<Boolean> booleans = List.of(true, false, true, false, true);
        int result1 = MyUtilityClass.aggregate(booleans, 0, (acc, v) -> v ? acc + 1 : acc);
        boolean result2 = MyUtilityClass.aggregate(booleans, true, (acc, v) -> acc & v);
        assertEquals(result1, 3);
        assertFalse(result2);
    }

    @Test
    void testAggregateNull(){
        List<Boolean> booleans = List.of(true, false, true, false, true);
        assertThrows(IllegalArgumentException.class,
                () -> {int result = MyUtilityClass.aggregate(booleans, null, (acc, v) -> v ? acc + 1 : acc);},
                "It should throw IllegalArgumentException");

        List<Boolean> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,
                () -> {int result = MyUtilityClass.aggregate(emptyList, null, (acc, v) -> v ? acc + 1 : acc);},
                "It should throw IllegalArgumentException");
    }

    @Test
    void testAggregateEmptyList(){
        List<Boolean> booleans = new ArrayList<>();
        int result = MyUtilityClass.aggregate(booleans, 0, (acc, v) -> v ? acc + 1 : acc);
        assertEquals(result,0);
    }

    @Test
    void testDuplicateNonEmpty(){
        record Person(String name) {}

        List<Object> persons = new ArrayList<>(){{
            add(new Person("Aurel"));
            add(new Person("Vali"));
            add(null);
        }};
        List<Object> otherPersons = new ArrayList<>(){{
            add(new Person("Aurel"));
            add(new Person("Aurel"));
            add(new Person("Vali"));
            add(new Person("Vali"));
            add(null);
            add(null);
        }};

        MyUtilityClass.duplicate(persons);
        assertEquals(persons,otherPersons);
    }

    @Test
    void testDuplicateEmpty(){
        ArrayList<Object> list = new ArrayList<>();
        MyUtilityClass.duplicate(list);
        assertEquals(list, new ArrayList<>());
    }

    @Test
    void testDuplicateSameObject(){
        record Person(String name) {}

        ArrayList<Object> list = new ArrayList<>(){{
            add(new Person("Aurel"));
        }};

        int code = System.identityHashCode(list);
        MyUtilityClass.duplicate(list);
        assertEquals(code, System.identityHashCode(list));
    }
}