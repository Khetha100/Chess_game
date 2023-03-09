package Chess;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
//import javax.swing.*;

public class Chess_board {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                super.paint(g);
          }

        };
        frame.add(panel);
        frame.setDefaultCloseOperation(5);
        frame.setVisible(true);

    }

}
