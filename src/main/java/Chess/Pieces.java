package Chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Pieces {




    public static BufferedImage image;
//    BufferedImage image = null;
    public static void main(String[] args) throws IOException {
        image = ImageIO.read(new File("one_each.png"));
//        image.createGraphics();
        int rows = 6;
        int columns = 2;
        BufferedImage img[] = new BufferedImage[32];
        int sub_image_width = image.getWidth();
        int sub_image_height = image.getHeight();
//        System.out.println(image);

//        public void show(){
//
//        }
        int image_current = 0;
        for (int i=0; i<rows;i++){
            for (int j =0; j<columns; j++){
                img[image_current] = new BufferedImage(sub_image_width,sub_image_height,image.getType());
                Graphics2D created_img = img[image_current].createGraphics();

                int source_first_x = sub_image_width*j;
                int source_first_y = sub_image_height*i;

                int dist_conner_x = sub_image_width*j + sub_image_width;
                int dist_conner_y = sub_image_height*i + sub_image_height;

                created_img.drawImage(image,0,0,sub_image_width,sub_image_height,source_first_x,source_first_y,dist_conner_x,dist_conner_y,null);
                image_current++;
            }
        }
        for (int i = 0; i< 32;i++){
            File outputFile = new File("img" + i + ".jpg");
            ImageIO.write(img[i], "jpg", outputFile);
        }
//        System.out.println();

    }



}
