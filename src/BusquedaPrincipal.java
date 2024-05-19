import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusquedaPrincipal {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/412b3f6887c970ddb02633ea/latest/";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "USD"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

                System.out.println("Respuesta completa:");
                System.out.println(jsonResponse);

                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

                System.out.println("\nTasas de cambio:");
                System.out.println(conversionRates);


                displayCurrencyRate(conversionRates, "ARS", "Peso argentino");
                displayCurrencyRate(conversionRates, "COP", "Pesp Colombiano");
                displayCurrencyRate(conversionRates, "BRL", "Real brasileño");


            } else {
                System.out.println("Error al obtener la respuesta. Código de estado: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void displayCurrencyRate(JsonObject rates, String currencyCode, String currencyName) {
        if (rates.has(currencyCode)) {
            String rate = rates.get(currencyCode).getAsString();
            System.out.println(currencyCode + " - " + currencyName + ": " + rate);
        } else {
            System.out.println("No se encontró la tasa de cambio para " + currencyName);
        }
    }
}
