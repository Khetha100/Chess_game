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
        BufferedImage[] img = new BufferedImage[32];
        int sub_image_width = image.getWidth()/6;
        int sub_image_height = image.getHeight()/2;
        System.out.println(image);

//        public void show(){
//        }
        int image_current = 0;
        for (int i=0; i<columns;i++){
            for (int j =0; j<rows; j++){
                System.out.println(sub_image_height);
                System.out.println(sub_image_width);
                System.out.println(image.getType());
//                img[image_current] = new BufferedImage(sub_image_width,sub_image_height,image.getType());
                img[image_current] = new BufferedImage(sub_image_width,sub_image_height,5);
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
            System.out.println(i);
            File outputFile = new File("img" + i + ".png");
            ImageIO.write(img[i], "png", outputFile);
        }
//        System.out.println();

    }



}
