package com.mycompany.quatro.slack;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class APP {
    public static void main(String[] args) throws IOException, InterruptedException {
        JSONObject json = new JSONObject();

        json.put("text", "Bem vindos a Quatro!");
        Slack.sendMessage(json);
    }
}

