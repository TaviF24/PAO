package task2;

import task1.SortedListSet;

import java.util.*;

public class WordMap implements WordCounter{

    private final HashMap<String, Integer> map;

    public WordMap() {
        map = new HashMap<>();
    }

    @Override
    public void parse(String text) {
        String[] strings = text.split("[\\s.,]");

        for(String s : strings){
            if(!s.isEmpty() && !map.containsKey(s)){
                map.put(s,1);
            }else if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
        }
    }

    @Override
    public int getCount(String word) {
        if(map.containsKey(word))
            return map.get(word);
        return 0;
    }

    @Override
    public SortedSet<String> getUniqueWords() {
        SortedSet<String> sortedSet = new SortedListSet<>();
        sortedSet.addAll(map.keySet());
        return sortedSet;
    }

    @Override
    public void printWordCounts() {

        SortedListSet<Tuple> sortedListSet = new SortedListSet<>();

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sortedListSet.add(new Tuple(entry.getKey(),entry.getValue()));
        }
        System.out.println(sortedListSet);
    }

    @Override
    public void reset() {
        map.clear();
    }

    private class Tuple implements Comparable<Tuple>{
        String word;
        Integer count;

        @Override
        public String toString() {
            return word + " " + count;
        }

        public Tuple(String word, Integer count){
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Tuple o) {
            if (count.equals(o.count)) {
                return word.compareTo(o.word);
            } else {
                return -count.compareTo(o.count);
            }
        }
    }

}
