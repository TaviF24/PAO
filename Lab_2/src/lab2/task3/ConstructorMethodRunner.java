package lab2.task3;

public class ConstructorMethodRunner {
    public static void main(String[] args) {
        foo(new B());
    }

    static void foo(A a) {
        a.add(8);
        a.print();
    }
}

class A {
    protected int number;
    A(int value) {
        add(value);
    }

    public void add(int value) {
        number += value;
    }

    public void print() {
        System.out.println(number);
    }
}

class B extends A {
    B() {
        super(2);
    }

    public void add(int value) {
        number += value * 2;
    }
}


/*
    20


    Nu este 18, pt ca constructorul clasei B, apeleaza constructorul clasei A cu parametrul 2, iar constructorul
    apeleaza functia add, dar cum si clasa B are functia add, o va apela pe acea => number = 2 * 2 = 4
    Apoi din functia foo, se apeleaza functia add din clasa B => number = 4 + 8*2 = 20
*/