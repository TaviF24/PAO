package org.example.task5;

import java.util.ArrayList;
import java.util.List;

public class Bilant implements Comparable<Bilant>{
    private int pozitive;
    private int negative;

    public Bilant() {
        new Bilant(0,0);
    }

    public Bilant(int pozitive, int negative) {
        this.pozitive = pozitive;
        this.negative = negative;
    }

    public int getPozitive() {
        return pozitive;
    }

    public void setPozitive(int pozitive) {
        this.pozitive = pozitive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    @Override
    public int compareTo(Bilant o) {
        int dif1 = pozitive-negative;
        int dif2 = o.pozitive-o.negative;
        if(dif1 == dif2 )
            return 0;
        else if (dif1 < dif2){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Bilant{" +
                "pozitive=" + pozitive +
                ", negative=" + negative +
                '}';
    }

    public static void main(String[] args){
        List<Bilant> list = new ArrayList<>(){{
            add(new Bilant());
            add(new Bilant(3,-6));
            add(new Bilant(2,-1));
        }};

        list.stream().sorted().forEach(x -> System.out.print(x + "    "));

    }
}
