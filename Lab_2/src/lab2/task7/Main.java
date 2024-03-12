package lab2.task7;

public class Main {
    public static void main(String[] args){

        Paralelogram paralelogram = new Paralelogram(10,18,90);
        System.out.println("Arie paralelogram: " + paralelogram.arie());

        Romb romb = new Romb(2,2,2);
        System.out.println("Arie romb: " + romb.arie());

        Dreptunghi dreptunghi = new Dreptunghi(10,18);
        System.out.println("Arie dreptunghi: " + dreptunghi.arie());

        Patrat patrat = new Patrat(5);
        System.out.println("Arie patrat: " + patrat.arie());

    }
}
