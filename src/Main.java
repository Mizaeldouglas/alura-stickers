import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Fazer conexão HTTp e buscar os top 250 Filmes
        String url = "https://imdb-api.com/en/API/BoxOfficeAllTime/k_p686jobp";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
        String body = response.body();

        // Extrair só os dados que interessam (titulo, poster, Classiicação)
        var parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);
        
        // Exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println();
            System.out.println("\u001b[40;1m "+"\u001b[31mNome do filme: "+filme.get("title")+" \u001b[m");
            System.out.println("\u001b[40;1m "+"Ano do filme: "+filme.get("year")+" \u001b[m");

            String rating = filme.get("foreign");
            System.out.println("\u001b[42m" +  "\u001b[30m Relevancia: " + rating + "\u001b[m");
            String stars = "";

//            for (int i = 0; i < Math.round(Float.parseFloat(rating)); i++) {
//                stars += "\u2B50";
//
//            }
//            System.out.print(stars);
//            System.out.println();


        }




















    }
}