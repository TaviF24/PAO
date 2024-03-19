package task2;

final class MyClass {
    public static String myFancyString = "Yes, I am fancy indeed!";
    public final int a;
    public MyClass(final int a) {
        this.a = a;
    }
}

class Main{
    public static void main(String[] args){
        MyClass.myFancyString="ana";
        System.out.println(MyClass.myFancyString);
    }
}