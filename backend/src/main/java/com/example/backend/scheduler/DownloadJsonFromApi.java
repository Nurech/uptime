package com.example.backend.scheduler;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.writeString;

//TODO check all memory leaks and close all connections
public class DownloadJsonFromApi {
    public static void main(String[] args) {
        String json = (getJsonFromUrl("https://cosmos-odyssey.azurewebsites.net/api/v1.0/TravelPrices"));
        String fileID = getSqlizerResponse(json);
        uploadJsonToSqlizer(fileID, json);
    }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    public static String getJsonFromUrl(String urlQueryString) {

        // GET json from url as string
        String json = null;
        try {
            URL url = new URL(urlQueryString);
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
            Path path = Paths.get("backend/src/main/java/com/example/backend/scheduler/downloads/file.json");
            String contents = json;
            try {
                writeString(path, contents, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                // TODO Handle exception
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    // USE SQLizer API, send initial request, get JSON response, read "ID" token for fileID
    @SneakyThrows
    public static String getSqlizerResponse(String sendSQLizer) {
        URL url = new URL("https://sqlizer.io/api/files/");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Authorization", "Bearer UWWParScxDdbutSmjYwgQdwzArgj0drOd1WncATauqOta8UzpcDaEI9H5JVThYxKuhIeyXhSZ41kydaUFAQ");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String data = "DatabaseType=PostgreSQL&FileType=json&FileName=file.json&TableName=flights_data&FileHasHeaders=true";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);

        //print response
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        InputStream in = http.getInputStream();
        String encoding = http.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        String body = IOUtils.toString(in, encoding);
        System.out.println(body);

        // take ID from body response
        JSONObject jsonObject = new JSONObject(body);
        String fileId = jsonObject.getString("ID");
        System.out.println("File ID is = " + fileId);
        http.disconnect();

        return fileId;
    }

    // Send fileID, upload file, receive SQL dialect
    @SneakyThrows
    public static String uploadJsonToSqlizer(String fileId, String json) {
        URL url = new URL("https://sqlizer.io/api/files/" + fileId + "/data/");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Authorization", "Bearer UWWParScxDdbutSmjYwgQdwzArgj0drOd1WncATauqOta8UzpcDaEI9H5JVThYxKuhIeyXhSZ41kydaUFAQ");
        http.setRequestProperty("Content-Type", "multipart/form-data");

        OutputStreamWriter wr = new OutputStreamWriter(http.getOutputStream());
        wr.write(json);
        wr.flush();
        System.out.println(http.getInputStream().toString());
        return "";
    }
}