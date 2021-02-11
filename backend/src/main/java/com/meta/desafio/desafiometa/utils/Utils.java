package com.meta.desafio.desafiometa.utils;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Utils {

  public static String retrieveWebPage(String URL) throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
        .proxy(ProxySelector.getDefault()).build();

    HttpRequest mainRequest = HttpRequest.newBuilder().uri(URI.create(URL)).build();

    return httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString()).body();
  }
}
