package Bonus;

import java.util.ArrayList;

/**
 * Created by mihai
 */
public class Test {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Math.round((float) Math.random() * 100));
        }
        System.out.println("Lista initiala:\n"+list+"\n");


        /*-----------------------------TEST 1-----------------------------*/
        //Exemplul pentru map din enunt

        System.out.println("TEST 1: Map");
        System.out.println(ListUtil.map(new Function<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return 2*x;
            }
        }, list));
        System.out.println();

        /*-----------------------------TEST 2-----------------------------*/
        /*TODO 1 - Pornind de la exemplul anterior pentru map, realizati un apel pentru filter
        Va trebui sa pastreze in lista doar numerele pare
        Trebuie sa inlocuiti valoarea null din apelul functionalei filter */

        System.out.println("TEST 2: Filter");
        System.out.println(ListUtil.filter(new Function<Integer, Boolean>() {
            @Override
            public Boolean execute(Integer object) {
                return object%2==0;
            }
        }, list));
        System.out.println();


        /*-----------------------------TEST 3-----------------------------*/
        System.out.println("TEST 3: Reverse");
        ListUtil.reverse(list);
        System.out.println(list);
        System.out.println();


        /*-----------------------------TEST 4-----------------------------*/
        //TODO 2 - Apelati sum pentru lista noastra (inlocuiti valorea null cu un Addition)

        System.out.println("TEST 4: Sum");
        System.out.println(ListUtil.sum(list, new Addition<Integer>() {
            @Override
            public Integer zero() {
                return 0;
            }

            @Override
            public Integer add(Integer nr1, Integer nr2) {
                return nr1+nr2;
            }
        }));
        System.out.println();


        /*-----------------------------TEST 5-----------------------------*/
        //Exemplu de functie ce urmeaza a fi data ca parametru lui foldl pentru a calcula suma elementelor

        System.out.println("TEST 5: Foldl");
        Function<Integer,Function<Integer,Integer>> add = new Function<Integer,Function<Integer,Integer>>(){
            @Override
            public Function<Integer,Integer> execute(final Integer a) {
                return new Function<Integer,Integer>(){
                    @Override
                    public Integer execute(Integer b) {
                        return a + b;
                    }
                };
            }
        };
        System.out.println(ListUtil.foldl(add, 0, list));
        System.out.println();


        /*-----------------------------TEST 6-----------------------------*/
        //Apelam si reducem cu aceasta functie

        System.out.println("TEST 6: Reduce");
        System.out.println(ListUtil.reduce(add, list));
        System.out.println();


        /*-----------------------------TEST 7-----------------------------*/
        //TODO 3 - Realizati o functie similara cu add pe care sa o folosim pentru a inversa elementele
        //Observatie: Vom folosi functionala foldr pentru a realiza acest lucru
        //Hint: Acumulatorul o sa fie lista vida si tot adaugam elemente la el (de la dreapta la stanga)
        //Trebuie sa inlocuiti cele doua valori null

        System.out.println("TEST 7: Foldr");
        Function<ArrayList<Integer>,Function<Integer,ArrayList<Integer>>> append = new Function<ArrayList<Integer>, Function<Integer, ArrayList<Integer>>>() {
            @Override
            public Function<Integer, ArrayList<Integer>> execute(ArrayList<Integer> objectsList) {
                return new Function<Integer, ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> execute(Integer object) {
                        objectsList.add(object);
                        return objectsList;
                    }
                };
            }
        };
        System.out.println(ListUtil.foldr(append, new ArrayList<>(), list));
        System.out.println();


        /*-----------------------------TEST 8-----------------------------*/
        //Exemplu de apel pentru all

        System.out.println("TEST 8: All");
        System.out.println(ListUtil.all(new Function<Integer, Boolean>() {
            @Override
            public Boolean execute(Integer x) {
                return x % 2 == 0;
            }
        }, list));
        System.out.println();


        /*-----------------------------TEST 9-----------------------------*/
        //Exemplu de apel pentru any

        System.out.println("TEST 9: Any");
        System.out.println(ListUtil.any(new Function<Integer, Boolean>() {
            @Override
            public Boolean execute(Integer x) {
                return x % 3 == 1;
            }
        }, list));
        System.out.println();
    }
}
