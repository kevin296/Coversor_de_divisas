import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/412b3f6887c970ddb02633ea/latest/";

    public static void convert(int option, int value) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "USD"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

                double conversionRate = 0;
                String fromCurrencyCode = "";
                String toCurrencyCode = "";

                switch (option) {
                    case 1: // Dólar => Peso Argentino
                        fromCurrencyCode = "USD";
                        toCurrencyCode = "ARS";
                        break;
                    case 2: // Peso Argentino => Dólar
                        fromCurrencyCode = "ARS";
                        toCurrencyCode = "USD";
                        break;
                    case 3: // Dólar => Real Brasileño
                        fromCurrencyCode = "USD";
                        toCurrencyCode = "BRL";
                        break;
                    case 4: // Real Brasileño => Dólar
                        fromCurrencyCode = "BRL";
                        toCurrencyCode = "USD";
                        break;
                    case 5: // Dólar => Peso Colombiano
                        fromCurrencyCode = "USD";
                        toCurrencyCode = "COP";
                        break;
                    case 6: // Peso Colombiano => Dólar
                        fromCurrencyCode = "COP";
                        toCurrencyCode = "USD";
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtalo de nuevo.");
                        return;
                }

                double fromRate = conversionRates.get(fromCurrencyCode).getAsDouble();
                double toRate = conversionRates.get(toCurrencyCode).getAsDouble();

                double convertedValue = (value / fromRate) * toRate;
                System.out.println("El valor ingresado de " + value + " en " + fromCurrencyCode + " corresponde a " + convertedValue + " " + toCurrencyCode);
            } else {
                System.out.println("Error al obtener la respuesta. Código de estado: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
