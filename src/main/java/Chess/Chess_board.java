package Chess;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
//import javax.swing.*;

public class Chess_board {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g){
//                super.paint(g);
                boolean white = true;
                for (int i = 0;i<8;i++){
                   for (int j = 0; j<8;j++){
                        if (white) {
                            g.setColor(Color.white.darker());
                        }
                        else{
                            g.setColor(Color.black.darker());
                        }
                        g.fillRect(i*64,j*64,64,64);
                        white=!white;
                   }
                   white =!white;
                }
          }


        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }

}
