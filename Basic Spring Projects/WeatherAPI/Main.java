//https://api.open-meteo.com/v1/forecast?latitude=12.948500&longitude=77.627586&current_weather=true
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import jso.JSONException;
import jso.JSONObject;

public class Main {

    public static void main(String[] args) {
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=12.948500&longitude=77.627586&current_weather=true"; // Replace this with the actual API URL

        try {
            // instance of HttpClient
            HttpClient httpClient = HttpClient.newHttpClient();

            // HTTP GET request to the API URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                System.out.println(": " + responseBody);
            } else {
                System.out.println("Failed @ Status code: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
}
