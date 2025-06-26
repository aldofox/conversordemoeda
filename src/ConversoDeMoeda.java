import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversoDeMoeda {

    private static final String API_KEY = "b134f49f9a51683bb3a54a33";
    private static final String URL = "https://v6.exchangerate-api.com/v6/";

    public double getTaxaCambio(String moedaAtual, String moedaCovertida) throws IOException, InterruptedException {
        //Criando a API
        String url = URL + API_KEY + "/latest/" + moedaAtual;

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest requisitar = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

        //Envia a Requisição e Aguarda uma resposta

        HttpResponse<String> reponde = cliente.send(requisitar, HttpResponse.BodyHandlers.ofString());

        //Verifica se tem algo de errado
        if (reponde.statusCode() == 200) {
            JsonObject jsonResponse  = JsonParser.parseString(reponde.body()).getAsJsonObject();
            JsonObject taxa = jsonResponse.getAsJsonObject("conversion_rates");
            if(taxa.has(moedaCovertida)){
                return taxa.get(moedaCovertida).getAsDouble();
            }else{
                throw new IllegalArgumentException("A moeda para conversão (" + moedaCovertida + ") não foi encontrada na API.");
            }
        }else{
            throw new IOException(("OPS. Acontenceu algum erro ao tenta obter dados da API. " + reponde.statusCode()));
        }

    }
}
