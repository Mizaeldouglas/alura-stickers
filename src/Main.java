import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        // Fazer conexão HTTp e buscar os top 250 Filmes

//        String url = "https://alura-imdb-api.herokuapp.com/movies";
//        ExtratorDeConteudo extrator = new ExtratorConteudosIMDB();

//        String url = "https://api.nasa.gov/planetary/apod?api_key=7Y6zfx5juOEC0S2gNVkdb6043NN6ON65P1oGFq20&start_date=2022-06-12&end_date=2022-06-14";
//        ExtratorDeConteudo extrator = new ExtratorConteudosNasa();


           String url = "http://localhost:8080/linguagens";
           ExtratorDeConteudo extrator = new ExtratorConteudosIMDB();



        var http = new clientHttp();
        String json = http.buscadorDados(url);

        // Exibir e manipular os dados

        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var geredora = new StickerGeneration();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo =  conteudo.getTitulo() + ".png";

            geredora.cria(inputStream,nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
//        }




















    }
}