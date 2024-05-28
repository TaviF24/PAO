package org.example.task2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPManager {
    private static final String jsonAPI = "https://jsonplaceholder.typicode.com/posts";
    private static final HttpClient client = HttpClient.newHttpClient();

    public static void getPost(int id) throws IOException, InterruptedException {
        String url = jsonAPI + "/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("GET Response:");
            System.out.println(response.body());
        } else {
            System.out.println("GET request failed. Response Code: " + response.statusCode());
        }
    }

    public static void createPost() throws IOException, InterruptedException {

        JsonObject postObject = new JsonObject();
        postObject.addProperty("userId", 1);
        postObject.addProperty("title", "Reteta");
        postObject.addProperty("body", "Tocanita");

        String jsonInputString = (new Gson()).toJson(postObject);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(jsonAPI))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("\nPOST Request Object:");
            System.out.println(jsonInputString);

            System.out.println("\nPOST Response:");
            System.out.println(response.body());
        } else {
            System.out.println("POST request failed. Response Code: " + response.statusCode());
        }
    }
}
