package org.pdi.Methods;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BinImagem {
    public static void BinarizarAImagem() {
        try {

            BufferedImage image = ImageIO.read(new File("C:\\Users\\kaiof\\Downloads\\sombrinhas.jpg"));

            int limiar = 100;

            int largura = image.getWidth();
            int altura = image.getHeight();

            for (int y = 0; y < altura; y++) {
                for (int x = 0; x < largura; x++) {

                    int pixel = image.getRGB(x, y);

                    int red = (pixel >> 16) & 0xFF;
                    int green = (pixel >> 8) & 0xFF;
                    int blue = pixel & 0xFF;

                    int valorCinza = (red + green + blue) / 3;

                    if (valorCinza < limiar) {
                        image.setRGB(x, y, 0xFF000000);
                    } else {
                        image.setRGB(x, y, 0xFFFFFFFF);
                    }
                }
            }

            ImageIO.write(image, "png", new File("imagem_binarizada.png"));

            System.out.println("Binarização concluída!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
