package org.example;

class A {
    public static int a = 0;
}

class B extends A {
    public static int a = 5;
}

public class T1 {
    public static void main(String[] args) {
        A a = new B();
        a.a++;
        System.out.println(A.a);
        System.out.println(B.a);
    }
}

/*
Output =
1
5
Variabila 'a' este statica, deci apartine clasei, nu obiectului. Variabila 'a' a clasei 'A' este diferita de cea din 'B'.
Clasa este aceea de la declarare (A) si nu cea de la runtime (B), deci 'a.a++' va creste variabila din clasa 'A'.
*/
