import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Api {
    private String base_code;
    private String target_code;
    private double amount;
    private String apiKey;
    List<Conversor> listConversor = new ArrayList<>();

    public Api(Conversor converson) {
        this.base_code = converson.getBase_code();
        this.target_code = converson.getTarget_code();
        this.amount = converson.getValor();

    }

    public String callApi()  {
        this.apiKey = "3dbee3ed742c74b47f4e9cde";
        String uriQuery = this.apiKey+"/pair/"+this.base_code+"/"+this.target_code+"/"+this.amount;

        try {
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/"+uriQuery);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();

            Conversor conversor = gson.fromJson(json, Conversor.class);
            listConversor.add(conversor);
            return conversor.toString();
        } catch (Exception e) {
            return "Erro" + e.getMessage();
        }
    }

    public List<Conversor> getListConversor() {
        return listConversor;
    }
}
