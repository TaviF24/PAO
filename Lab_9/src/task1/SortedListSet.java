package task1;

import java.util.*;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {

    private Comparator<T> comparator = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    };

    public SortedListSet(){}

    public SortedListSet(Comparator<T> comparator){
        this.comparator = comparator;
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public boolean add(T t) {
        if(contains(t))
            return false;

        super.add(t);
        sort(comparator);
        return true;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        int fromIndex = indexOf(fromElement);
        int toIndex = indexOf(toElement);

        ListIterator<T> listIterator = listIterator(fromIndex);
        TreeSet<T> treeSet = new TreeSet<>();
        while(fromIndex<toIndex && listIterator.hasNext()){
            treeSet.add(listIterator.next());
            fromIndex++;
        }

        return treeSet;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        int fromIndex = 0;
        int toIndex = indexOf(toElement);

        ListIterator<T> listIterator = listIterator(0);
        TreeSet<T> treeSet = new TreeSet<>();
        while(fromIndex<toIndex && listIterator.hasNext()){
            treeSet.add(listIterator.next());
            fromIndex++;
        }

        return treeSet;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        int fromIndex = indexOf(fromElement);
        ListIterator<T> listIterator = listIterator(fromIndex);
        TreeSet<T> treeSet = new TreeSet<>();
        while(listIterator.hasNext()){
            treeSet.add(listIterator.next());
        }
        return treeSet;
    }

    @Override
    public T first() {
        return getFirst();
    }

    @Override
    public T last() {
        return getLast();
    }
}
