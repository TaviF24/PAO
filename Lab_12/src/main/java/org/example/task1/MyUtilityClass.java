package org.example.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiFunction;

public class MyUtilityClass {

    public static void printCollection(Collection<?> list){
        System.out.println(list);
    }

    public static <T, R> R aggregate(Collection<T> list, R startValue, BiFunction<R, T, R> function) {
        try{
            R result = startValue;
            for (T element : list) {
                result = function.apply(result, element);
            }
            if(result == null){
                throw new IllegalArgumentException();
            }
            return result;
        }catch (NullPointerException e){
            throw new IllegalArgumentException();
        }
    }

    public static <T> void duplicate(Collection<T> list){
        Collection<T> arrayList = new ArrayList<>(list);
        list.clear();
        for(T t : arrayList){
            list.add(t);
            list.add(t);
        }
    }



}
