package org.example.task3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Absolut path for repository:");
            Scanner in = new Scanner(System.in);
            String path = in.nextLine();
            GitInit.execute(path);
            System.out.println("Success");
        }
        catch (IOException e){
            System.out.println("Failed");
            System.out.println(e);
        }

    }
}
