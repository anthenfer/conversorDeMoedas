import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    private static final String CHAVE_API = "748cac8c996e928c7726d9a5";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient client;
    private final Gson gson;

    public Conversor() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double convert(String from, String to) {
        String endpoint = BASE_URL + CHAVE_API + "/pair/" + from + "/" + to;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ExchangeAPI resultado = gson.fromJson(response.body(), ExchangeAPI.class);
                return resultado.getConversion_rate();
            } else {
                System.out.println("Erro na resposta da API: Código " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar taxa de câmbio: " + e.getMessage());
        }

        return -1;
    }
}
