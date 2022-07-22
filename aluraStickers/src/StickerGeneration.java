import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerGeneration {

    public void cria( InputStream inputStream, String nomeArquivo ) throws Exception {

        // Leitura da imagem

//        InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
//        InputStream inputStream =
//                new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Cria nova imagem em memória com transparencia e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar imagem original (em Memoria)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0,null);

        // config font

        var fonte =new Font(Font.SANS_SERIF,Font.BOLD, 30);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);


        // Escrever uma frase na nova imagem

        graphics.drawString("Mizaeldouglas",100,novaAltura - 100);


        // Escrever a nova imagem em uma arquivo

        ImageIO.write(novaImagem,"png",new File("saida/" + nomeArquivo));
    }

}
