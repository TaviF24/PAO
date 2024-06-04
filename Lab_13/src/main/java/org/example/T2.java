package org.example;

class C {
    public C() {
        System.out.println("C");
    }

    public C(int x) {
        System.out.println("C " + x);
    }
}

class D extends C {
    public D() {
        super(1);
        System.out.println("D");
    }

    public D(int x) {
        System.out.println("D " + x);
    }
}

class E extends D {
    public E() {
        super(1);
        System.out.println("E");
    }
}

public class T2 {
    public static void main(String[] args) {
        new E();
    }
}
/*
Output:
C
D 1
E

Mai intai se apeleaza constructorul din clasa E. Constructorul din clasa E apeleaza constructorul parametrizat al clasei parinte
D. In interiorul acestui constructor se apeleaza constructorul default al clasei parinte C (daca nu apelam noi vreun constructor
din parinte, se apeleaza automat cel default)==> se printeaza "C". Apoi revine in constructorul parametrizat din clasa D ==> se
printeaza "D 1". Mai apoi se intoarce in constructorul clasei E ==> se printeaza "E".
*/
