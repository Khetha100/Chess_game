package Chess;

import javax.swing.JFrame;
import java.awt.*;

public class Chess_board {
    private static final String TITLE = "Chess";
    public static void main(String[] args) {


//        JFrame frame = new JFrame();
//        frame.setBounds(10, 10, 512, 512);
//        frame.setUndecorated(true);
//
//        PanelClass panel = new PanelClass();
//        frame.add(panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame(TITLE);
                PanelClass panelClass = new PanelClass();
                System.out.println(panelClass);
                f.add(panelClass);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });

    }


}
