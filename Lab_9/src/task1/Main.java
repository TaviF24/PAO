package task1;

import java.util.SortedSet;

public class Main {
    public static void main(String[] args){
        SortedListSet<Integer>sortedListSet = new SortedListSet<>();

        sortedListSet.add(5);
        sortedListSet.add(1);
        sortedListSet.add(7);
        sortedListSet.add(3);
        sortedListSet.add(2);
        sortedListSet.add(6);

        System.out.println(sortedListSet);

        System.out.println(sortedListSet.subSet(2,6));

        System.out.println(sortedListSet.headSet(7));

        System.out.println(sortedListSet.tailSet(3));

        System.out.println(sortedListSet.first());

        System.out.println(sortedListSet.last());

    }
}
