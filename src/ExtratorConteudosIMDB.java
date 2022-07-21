import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.replaceAll;

public class ExtratorConteudosIMDB implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudos (String json){

        // Extrair só os dados que interessam (titulo, poster, Classiicação)
        var parser = new JsonParser();
        List<Map<String,String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // Popular a lista de conteudos

        for (Map<String, String> atributos : listaDeAtributos){

            String urlImagem = atributos.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String titulo =  atributos.get("title");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;

    }


}
