package Chess;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Pieces {
    public static BufferedImage image;
//    BufferedImage image = null;
    public static void main(String[] args){
        image = ImageIO.read(new File(one_each.png));
        int rows = 6;
        int columns = 2;
        BufferedImage img[] = new BufferedImage[32];
        int sub_image_width = image.getWidth();

    }



}
