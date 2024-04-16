package Bonus;

import java.util.*;

public class ListUtil {
    public static <A, B> A foldl(Function<A, Function<B, A>> function, A acc, List<B> xs) {

//        A res = acc;
        for(B b : xs){
            acc = function
                    .execute(acc)
                    .execute(b);
        }
        return acc;
    }

    public static <A> void reverse(List<A> xs) {

        int i = 0;
        int j = xs.size()-1;
        A obj;

        while(i < xs.size()/2 + xs.size()%2){
            obj = xs.get(i);
            xs.set(i,xs.get(j));
            xs.set(j,obj);
            i++;
            j--;
        }

        //Hint: Folositi iteratori
    }

    public static <A, B> A foldr(Function<A, Function<B, A>> function, A acc, List<B> xs) {

        reverse(xs);
        return foldl(function, acc, xs);

        //Hint: reverse + foldl
    }

    public static <A, B> List<B> map(Function<A, B> function, List<A> xs) {
        return xs.stream()
                .map(x -> function.execute(x))
                .toList();
    }

    public static <A> List<A> filter(Function<A, Boolean> function, List<A> xs) {
        return xs.stream()
                .filter(x -> function.execute(x))
                .toList();
    }

    public static <A> A reduce(Function<A, Function<A, A>> function, List<A> xs) {
        A obj = xs.get(0);
        return foldl(function, obj, xs.subList(1,xs.size()));
    }

    public static <A> boolean all(Function<A, Boolean> function, List<A> xs) {
        return (filter((Boolean a) -> !a, map(function, xs))).isEmpty();
    }

    public static <A> boolean any(Function<A, Boolean> function, List<A> xs) {
        for(A obj : xs){
            if(function.execute(obj)){
                return true;
            }
        }
        return false;
    }

    public static <A extends Number> A sum(List<A> xs, Addition<A> operation) {
        A s = operation.zero();
        for(A obj : xs){
            s = operation.add(s,obj);
        }
        return s;
    }
}
