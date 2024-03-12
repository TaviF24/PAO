package lab2.task4;

public class OtherRunner {
    public static void main(String[] args) {
        (new PA(2)).print();
    }
}

class PA {
    protected int value;

    public PA(int value) {
        add(value);
    }

    private void add(int value) {
        this.value += value;
    }

    public void print() {
        System.out.println(value);
    }
}

class PB extends PA {
    public PB(int value) {
        super(value);
    }

    private void add(int value) {
        this.value += value * 2;
    }
}


/*
    2

    Nu se leaga de nimic din clasa PB asa ca isi apeleaza metodele din tipul sau
*/