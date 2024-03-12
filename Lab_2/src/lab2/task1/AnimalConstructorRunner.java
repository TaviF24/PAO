package lab2.task1;

public class AnimalConstructorRunner {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.test();
    }
}

class Animal {
    public Animal() {
        System.out.println("Animal");
    }


    public void test(){
        System.out.println("A");
    }
}

class Dog extends Animal {
    public Dog() {
        System.out.println("Dog");
    }
    public void test(){
        System.out.println("D");
    }
}

/*
    Animal
    Dog
    D


    Mai intai se apeleaza constructorul superclasei si apoi consructorul subclasei
    Obiectul dog are corp de Animal si suflet de Dog.
    El nu poate folosi metoda test daca nu este declarata si in Animal
*/
