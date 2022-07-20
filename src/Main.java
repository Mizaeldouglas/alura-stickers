import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        // Fazer conexão HTTp e buscar os top 250 Filmes
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
        String body = response.body();

        // Extrair só os dados que interessam (titulo, poster, Classiicação)
        var parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);
        
        // Exibir e manipular os dados

        var geredora = new StickerGeneration();

        for (Map<String, String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivo = titulo + ".png";


            geredora.cria(inputStream,nomeArquivo);

            System.out.println(titulo);
            System.out.println();

//            System.out.println();
//            System.out.println("\u001b[40;1m "+"\u001b[31mNome do filme: "+filme.get("title")+" \u001b[m");
//            System.out.println("\u001b[40;1m "+"Ano do filme: "+filme.get("year")+" \u001b[m");
//
//            String rating = filme.get("imDbRating");
//            System.out.println("\u001b[42m" +  "\u001b[30m Nota do filme: " + rating + "\u001b[m");
//            String stars = "";
//
//            for (int i = 0; i < Math.round(Float.parseFloat(rating)); i++) {
//                stars += "\u2B50";
//
//            }
//            System.out.print(stars);
//            System.out.println();


        }




















    }
}