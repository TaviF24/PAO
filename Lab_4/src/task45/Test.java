package task45;

public class Test {
    public static void foo() {
        try {
            System.out.println("1");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("2");
        }

        System.out.println("3");
    }

    //------------------Task 5-------------------//
    public static void bar() {
        try {
            try{
                throw new ClassCastException();
            }
            catch (ClassCastException ignored){}
        } catch (RuntimeException e) {
            System.out.println("fail");
        }
    }
}
