package com.java.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient=HttpClient.newHttpClient();

        HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create("https://www.google.com")).build();

        HttpResponse<String> httpResponse=httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        System.out.println("response.body() "+httpResponse.body());
    }
}
