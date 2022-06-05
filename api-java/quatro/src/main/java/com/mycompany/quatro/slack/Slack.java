package com.mycompany.quatro.slack;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import org.json.JSONObject;


public class Slack {
     private static final HttpClient client = HttpClient.newHttpClient();
     private static final String url = "https://hooks.slack.com/services/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";
     private static final JSONObject json = new JSONObject();
     private static DecimalFormat decimalFormat =  new DecimalFormat("0.00");

    public static void validateCpuUsage(Double cpuUsage) throws IOException, InterruptedException {
        if(cpuUsage <= 60){
            json.put("text",  "Processador estável. Uso de: " + decimalFormat.format(cpuUsage) + "%");
            sendMessage(json);
        } else if (cpuUsage <= 90){
            json.put("text","Processador em alerta, uso elevado. Uso de: " + decimalFormat.format(cpuUsage) + "%");
            sendMessage(json);
        } else {
            json.put("text","ATENÇÃO!! Processador está em uso extremo, AÇÃO NECESSÁRIA. Uso de: " + decimalFormat.format(cpuUsage) + "%");
            sendMessage(json);
        }
    }


    public static void validateRamUsage(Double ramUsage, Double totalRam) throws IOException, InterruptedException {
        Double usagePercentage = (ramUsage * 100) / totalRam;

        if(ramUsage <= totalRam * 0.6) {
            json.put("text", "Memória estável. Uso de: " + decimalFormat.format(usagePercentage) + "%");
            sendMessage(json);
        } else if (ramUsage <= totalRam * 0.9){
            json.put("text","Memória em alerta, uso elevado. Uso de: " + decimalFormat.format(usagePercentage) + "%");
            sendMessage(json);
        } else {
            json.put("text","ATENÇÃO!! Memória está em uso extremo, AÇÃO NECESSÁRIA. Uso de: " + decimalFormat.format(usagePercentage) + "%");
            Slack.sendMessage(json);
        }
    }

    public static void validateDiskUsage(Double diskUsage, Double totalSpace) throws IOException, InterruptedException {
        Double usagePercentage = (diskUsage * 100) / totalSpace;

        if(diskUsage <= totalSpace * 0.6) {
            json.put("text", " Disco estável. Uso de: " + decimalFormat.format(usagePercentage) + "%");
            sendMessage(json);
        } else if (diskUsage <= totalSpace + 0.9) {
            json.put("text"," Disco em alerta, uso elevado. Uso de: " + decimalFormat.format(diskUsage) + "%");
            sendMessage(json);
        } else {
            json.put("text","ATENÇÃO!! Disco está em uso extremo, AÇÃO NECESSÁRIA. Uso de: " + decimalFormat.format(diskUsage) + "%");
            sendMessage(json);
        }
    }

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
         HttpRequest request = HttpRequest.newBuilder(
                URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
