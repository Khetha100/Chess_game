package Chess;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
//import javax.swing.*;

public class Chess_board {

    private static Point mousePt;

    private static final int W = 512;
    private static final int H = 512;
//    public static Random random = new Random();
    public static Point objPt = new Point(W / 2, H / 2);

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);
        JPanel panel = new JPanel(){
            @Override
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
                                g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, this);
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
                                    g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, this);

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

                this.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        mousePt = e.getPoint();
                        repaint();
                    }
                });

                this.addMouseMotionListener(new MouseMotionAdapter() {

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        int dx = e.getX() - mousePt.x;
                        int dy = e.getY() - mousePt.y;
                        objPt.setLocation(objPt.x + dx, objPt.y + dy);
                        mousePt = e.getPoint();
                        repaint();
                    }


                });



          }


        };
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


public static String checkSpaceFilling(int currentWidth, int currentHeight){
        List<Integer> widhtList = List.of(0, 64, 128, 192, 256, 320, 384, 448);
        List<Integer> heightList = List.of(0, 64);
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
