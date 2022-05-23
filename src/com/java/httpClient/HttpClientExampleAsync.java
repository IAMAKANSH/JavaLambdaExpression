package com.java.httpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientExampleAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://www.google.com")).build();

        CompletableFuture<Void> response=client.sendAsync(request,HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println);
        response. get();
    }
}
