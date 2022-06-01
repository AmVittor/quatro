package com.mycompany.quatro.slack;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class Slack {
     private static final HttpClient client = HttpClient.newHttpClient();
     private static final String url = "https://hooks.slack.com/services/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";
    
    public static void sendMessage(JSONObject content)throws IOException, InterruptedException{
         HttpRequest request = HttpRequest.newBuilder(
                URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
         
          System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
