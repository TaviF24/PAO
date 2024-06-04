package org.example;

class F {
    public int a = 0;
}

public class T3 {
    public static void main(String[] args) {
        F f = new F();
        bar(f);
        System.out.println(f.a);
        System.out.println(foo());
    }

    private static void bar(F f) {
        try {
            f.a = 1;
        } finally {
            f.a = 2;
        }
    }

    private static int foo() {
        try {
            return 0;
        } finally {
            return 3;
        }
    }
}

/*
Output:
2
3

Mai intai se apeleaza functia 'bar'. Variabila 'a' ia mai intai valoarea 1, dar cum avem un camp finally, valoarea lui 'a' se va
schimba in 2. Se printeaza 2. Se apeleaza functia 'foo'. Desi avem return si pe try si pe finally, cel din try va fi ignorat,
executandu-se cel din finally. Se printeaza 3. Ce se afla in campul finally se va executa mereu, indiferent de ce este in celelalte
campuri.
*/
