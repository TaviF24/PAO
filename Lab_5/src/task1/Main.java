package task1;

import java.io.Serializable;
import java.util.List;

public class Main {
    public static void main(String[] args){

        MyOptional<String> o1 = MyOptional.of(new String("asd"));
        System.out.println(o1.isPresent()); // true
        System.out.println(o1.get()); // "asd"
        System.out.println();

        MyOptional<Object> o2 = MyOptional.of(List.of("1", "2"));
        System.out.println(o2.isPresent()); // true
        System.out.println(o2.get()); // ["1", "2"]
        System.out.println();

        MyOptional<Serializable> o3 = MyOptional.of(null);
        System.out.println(o3.isPresent()); // false
        System.out.println(o3.get()); // NoSuchElementException
        System.out.println();

//        MyOptional<Integer> o4 = MyOptional.of("3"); // eroare de compilare

    }
}
