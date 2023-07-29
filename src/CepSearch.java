import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepSearch {

    public Address searchAddress(String cep){
        URI address = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Address.class);
        } catch (Exception e) {
            throw new RuntimeException("Endereço não encontrado!");
        }
    }
}
