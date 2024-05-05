import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {
    // Método para obter a taxa de conversão de uma moeda para outra
    public static double getConversionRate(String fromCurrency, String toCurrency) {
        // Obtemos os dados da API
        String responseBody = callAPI(fromCurrency);

        // Convertemos os dados da resposta para JSON
        JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Verificamos se os códigos de moeda fornecidos são válidos
        if (!conversionRates.has(toCurrency)) {
            throw new IllegalArgumentException("Moeda de destino inválida: " + toCurrency);
        }

        // Retornamos a taxa de conversão da moeda de 'fromCurrency' para 'toCurrency'
        return conversionRates.get(toCurrency).getAsDouble();
    }

    // Método para chamar a API e obter os dados de conversão de moeda
    private static String callAPI(String fromCurrency) {
        // Construímos a URL do endpoint da API usando o código da moeda de origem fornecido
        String endpoint = "https://v6.exchangerate-api.com/v6/6e56a55f83ce147e31e060d5/latest/" + fromCurrency;

        try {
            // Construímos uma requisição HTTP com base na URL do endpoint
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .build();

            // Enviamos a requisição HTTP e recebemos a resposta
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificamos se houve erro na resposta da requisição
            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao obter a taxa de conversão: " + response.body());
            }

            // Retornamos o corpo da resposta
            return response.body();
        } catch (Exception e) {
            // Capturamos e lançamos uma exceção caso ocorra algum erro durante o processo
            throw new RuntimeException("Erro ao chamar a API: " + e.getMessage());
        }
    }
}
