package org.example.task2;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try {
            Random random = new Random();
            int id = random.nextInt(100) + 1;
            HTTPManager.getPost(id);

            HTTPManager.createPost();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
