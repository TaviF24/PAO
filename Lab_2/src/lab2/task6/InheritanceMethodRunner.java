package lab2.task6;

public class InheritanceMethodRunner {
    public static void main(String[] args) {
        (new D()).foo();
    }
}

class C {
    public void foo() {
        bar(this);
    }
    public void bar(C c) {
        System.out.println("C");
    }

    public void bar(D d){
        System.out.println("CD");
    }
}

class D extends C {

    public void bar(D d) {
        System.out.println("D");
    }
}


/*
    C


    Mai intai fac un obiect de tip D ce apeleaza foo din C (daca aveam suprascrisa foo si in D, o apela pe aceea).
    Apoi va fi apelata bar din C pentru ca this este de tipul C. bar din D nu are cum sa fie apelata pt ca foo
nu e suprascrisa si in D si deci nu are acces la ce contine subclasa sa.

*/
