package com.example.backend.scheduler;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.Files.writeString;

public class GetJsonGetSql {

    //SQLizer API key
    private static String API_KEY = "4ejggYADZS1VtkAgNQnz0TZp8r8AKjq3LowSUqjBIERJMvo3khCkc9DqXzmSWDnB1Co6WwtctjxR7bgxgkzUNA";
    // URL to download JSON from
    private static String jsonUrl = "https://cosmos-odyssey.azurewebsites.net/api/v1.0/TravelPrices";
    // where to save downloaded SQL
    private static String saveDir = "backend/src/main/resources/downloads";

    public void getJsonGetSql() throws IOException, InterruptedException {

        //DOWNLOAD JSON FROM API
        String json = downloadJson(jsonUrl);

        // add row_id to before "id" in json
        File textFile = new File("backend/src/main/resources/downloads/file.json");
        String data = FileUtils.readFileToString(textFile);
        data = data.replaceFirst("\"id\"","\"row_id\": \"replaceME\",\n" +
                "\t\"id\"");
        FileUtils.writeStringToFile(textFile, data);

        //GET FILE ID
        HttpClient client = HttpClient.newHttpClient();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("FileType", "json");
        parameters.put("FileName", "file.json");
        parameters.put("TableName", "flights");
        parameters.put("DatabaseType", "PostgreSQL");
        parameters.put("FileHasHeaders", "false");
        parameters.put("InsertSpacing", "1000");

        String form = parameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        HttpRequest postUploadFileInitialize = HttpRequest.newBuilder()
                .uri(URI.create("https://sqlizer.io/api/files/"))
                .setHeader("Authorization", "Bearer " + API_KEY)
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(form))
                .build();

        HttpResponse<String> response = client.send(postUploadFileInitialize, HttpResponse.BodyHandlers.ofString());
        String bracesRemoved = response.body().replace("{", "").replace("}", "");

        String id = "";
        for (String possible : bracesRemoved.split(",")) {
            if (possible.contains("ID")) {
                String quoted = possible.split(":")[1];
                id = quoted.replaceAll("\"", "");
            }
        }


        // UPLOAD

        List<String> file = new ArrayList<>(Files.readAllLines(Path.of("backend/src/main/resources/downloads/file.json")));
        List<byte[]> bytes = new ArrayList<>();
        bytes.add("--ThisIsABoundryWeeeeeeee\r\nContent-Disposition: form-data; name=\"file\"; filename=\"file.json\"\r\nContent-Type: application/octet-stream\r\n\r\n".getBytes(StandardCharsets.UTF_8));
        file.forEach(line -> bytes.add((line + "\r\n").getBytes(StandardCharsets.UTF_8)));
        bytes.add("--ThisIsABoundryWeeeeeeee--".getBytes(StandardCharsets.UTF_8));

        byte[] result = flatByteList(bytes);
        HttpRequest postUploadFile = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(60))
                .uri(URI.create("https://sqlizer.io/api/files/" + id + "/data/"))
                .setHeader("Authorization", "Bearer " + API_KEY)
                .setHeader("Content-Type", "multipart/form-data; boundary=ThisIsABoundryWeeeeeeee")
                .POST(HttpRequest.BodyPublishers.ofByteArray(result))
                .build();
        HttpResponse<String> uploadResponse = client.send(postUploadFile, HttpResponse.BodyHandlers.ofString());
        System.out.println(uploadResponse.body());
        Thread.sleep(5000);

        HttpRequest getResult = HttpRequest.newBuilder()
                .uri(URI.create("https://sqlizer.io/api/files/" + id))
                .setHeader("Authorization", "Bearer " + API_KEY)
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .GET()
                .build();

        HttpResponse<String> resultssss = client.send(getResult, HttpResponse.BodyHandlers.ofString());
        System.out.println(resultssss.body());
        Thread.sleep(2000);

        // PUT

        Map<String, String> putParameters = new HashMap<>();
        putParameters.put("Status", "Uploaded");

        String putForm = putParameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(putParameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        HttpRequest putUploadConvert = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(60))
                .uri(URI.create("https://sqlizer.io/api/files/" + id))
                .setHeader("Authorization", "Bearer " + API_KEY)
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .PUT(HttpRequest.BodyPublishers.ofString(putForm))
                .build();

        HttpResponse<String> putResponse = client.send(putUploadConvert, HttpResponse.BodyHandlers.ofString());
        System.out.println(putResponse.body());


        //CHECK STATUS
        String status = "";
        String getLink = "";

        while (!status.equals("Complete")) {

            HttpRequest checkStatus = HttpRequest.newBuilder()
                    .timeout(Duration.ofSeconds(60))
                    .uri(URI.create("https://sqlizer.io/api/files/" + id))
                    .setHeader("Authorization", "Bearer " + API_KEY)
                    .setHeader("Content-Type", "application/x-www-form-urlencoded")
                    .GET()
                    .build();

            HttpResponse<String> statusResponse = client.send(checkStatus, HttpResponse.BodyHandlers.ofString());
            System.out.println(statusResponse.body());
            Thread.sleep(500);
            String statusRemoveBraces = statusResponse.body().replace("{", "").replace("}", "");
            String resultUrlRemoveBraces = statusResponse.body().replace("{", "").replace("}", "");

            for (String possible : statusRemoveBraces.split(",")) {
                if (possible.contains("Status")) {
                    String quoted = possible.split(":")[1];
                    status = quoted.replaceAll("\"", "");
                }
            }

            // extract url, make browser friendly
            for (String possible : resultUrlRemoveBraces.split(",")) {
                if (possible.contains("ResultUrl")) {
                    String quoted = possible.split(":")[2];
                    getLink = "https:" + quoted.replaceAll("\"", "").replace("\\u0026", "&");
                }
            }
        }

        System.out.println("{\"Status\":\"Get Link\"} " + getLink);

        try {
            HttpDownloadUtility.downloadFile(getLink, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static String downloadJson(String jsonUrl) {
        //DOWNLOAD JSON
        String json = null;
        try {
            URL url = new URL(jsonUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string

            // save string as JSON
            Path path = Paths.get("backend/src/main/resources/downloads/file.json");
            String contents = json;
            try {
                writeString(path, contents, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                // TODO Handle exception
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("{\"Status\":\"JSON Downloaded\"} " + json.substring(1, 60) + "...");

        return json;
    }


    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    private static byte[] flatByteList(List<byte[]> list) {
        int length = 0;
        for (byte[] byteArr : list) {
            length += byteArr.length;
        }
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] arr : list) {
            for (byte b : arr) {
                result[pos++] = b;
            }
        }
        return result;
    }

}
