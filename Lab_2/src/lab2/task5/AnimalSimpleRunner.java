package lab2.task5;

public class AnimalSimpleRunner {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.produceSound();

        Cat cat = new Cat();
        ((Animal) cat).produceSound();
    }
}

class Animal {
    public void produceSound() {
        System.out.println("<Undefined sound>");
    }
}

class Dog extends Animal {
    public void produceSound() {
        System.out.println("BARK!");
    }
}

class Cat extends Animal {
    public void produceSound() {
        System.out.println("Meow!");
    }
}


/*
    BARK!
    Meow!




    Obiectul dog apeleaza metoda produceSound din Dog, explicatie:
        variabila dog este o referinta de tip Animal la un obiect de tip Dog (cred)

    Obiectul cat apeleaza metoda produceSound din Cat, explicatie:
        variabila cat este initial o referinta de tip Cat la un obiect de tip Cat. Apoi i se face
        cast (referintei) dar ea va pointa tot catre un obiect de tip Cat
*/
