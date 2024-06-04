package org.example.task6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharCounter {

    private static ArrayList<String> read(String path) {
        File file = new File(path);
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("\nOops\n" + e);
        }
        return lines;
    }

    private static long calculate(ArrayList<String> lines, String character) {
        return lines.parallelStream().mapToInt(line -> {
            int cnt = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == character.charAt(0)) {
                    cnt++;
                }
            }
            return cnt;
        }).sum();
    }
    public static long execute(String character, String path) {
        ArrayList<String> lines = read(path);
        return calculate(lines, character);
    }

    public static void main(String[] args){
        try {
            if (args.length < 2) {
                throw new IllegalArgumentException("Invalid number of parameters.\nCorrect form: java CharCounter.java (char) (absolute path)");
            }
            if (args[0].length() > 1) {
                throw new IllegalArgumentException("That is not char. Try again");
            }
            long cnt = CharCounter.execute(args[0], args[1]);
            System.out.println("\nCharacter '" + args[0] + "' appears: " + cnt + " times in file: " + args[1] + "\n");
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
