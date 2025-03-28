package Chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Piece extends JPanel {

    List<Image> listOfPieces = new ArrayList<>();
    Rectangle r;

    public Piece(){

    }

    public void setRect(int x, int y) {
        r.x = x;
        r.y = y;
        repaint();
    }

    public void paint(Graphics g){
        Image image = null;
        boolean white = true;
        for (int i = 0;i<8;i++){
            for (int j = 0; j<8;j++){

                if (white) {
                    if (checkSpaceFilling(i * 64, j * 64) != null) {

                        File sourceimage = new File("./pieces/" + checkSpaceFilling(i * 64, j * 64));

                        try {
                            image = ImageIO.read(sourceimage);
                            g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, null);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    g.setColor(Color.white.darker());

                }
                else{
                    g.fillRect(i*64,j*64,64,64);
//                            System.out.println("at grey space");
                    if (checkSpaceFilling(i * 64, j * 64) != null) {
//                                System.out.println("at not null grey space");
                        File sourceimage = new File("./pieces/" + checkSpaceFilling(i * 64, j * 64));

                        try {
                            image = ImageIO.read(sourceimage);
                            g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, null);

//                            DragHandler handler = new DragHandler(test);
//                            test.addMouseListener(handler);
//                            test.addMouseMotionListener(handler);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    g.setColor(Color.gray.darker());


                }


                white=!white;
            }
            white =!white;
        }
    }

    public static String checkSpaceFilling(int currentWidth, int currentHeight){
        java.util.List<Integer> widhtList = java.util.List.of(0, 64, 128, 192, 256, 320, 384, 448);
        java.util.List<Integer> heightList = List.of(0, 64);
//        if(currentHeight>64 && currentHeight<384){
//            return "";
//        }
        if(currentWidth == 0 && currentHeight == 0){
            return "castle-b.png";
        }
        else if(currentWidth == 64 && currentHeight == 0){
            return "knight-b.png";
        }
        else if(currentWidth == 128 && currentHeight == 0){
            return "bishop-b.png";
        }
        else if(currentWidth == 192 && currentHeight == 0){
            return "queen-b.png";
        }

        else if(currentWidth == 256 && currentHeight == 0){
            return "king-b.png";
        }

        else if(currentWidth == 320 && currentHeight == 0){
            return "bishop-b.png";
        }

        else if(currentWidth == 384 && currentHeight == 0){
            return "knight-b.png";
        }
        else if(currentWidth == 448 && currentHeight == 0){
            return "castle-b.png";
        }
        else if(currentHeight == 64){
            return "pawn-b.png";
        }

        else if(currentHeight == 384){
            return "pawn-w.png";
        }

        if(currentWidth == 0 && currentHeight == 448){
            return "castle-w.png";
        }
        else if(currentWidth == 64 && currentHeight == 448){
            return "knight-w.png";
        }
        else if(currentWidth == 128 && currentHeight == 448){
            return "bishop-w.png";
        }
        else if(currentWidth == 192 && currentHeight == 448){
            return "queen-w.png";
        }

        else if(currentWidth == 256 && currentHeight == 448){
            return "king-w.png";
        }

        else if(currentWidth == 320 && currentHeight == 448){
            return "bishop-w.png";
        }

        else if(currentWidth == 384 && currentHeight == 448){
            return "knight-w.png";
        }
        else if(currentWidth == 448 && currentHeight == 448){
            return "castle-w.png";
        }
//    System.out.println(currentHeight);
        return null;

    }


}


