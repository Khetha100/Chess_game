package Chess;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectAndDragTest extends JPanel {

    private static final String TITLE = "House";
    private static final int W = 512;
    private static final int H = 512;
//    public static Random random = new Random();
    public static Point objPt = new Point(64 / 2, 64 / 2);
    private Point mousePt;
//    House house;
//    public static JButton btnAdd;

    public SelectAndDragTest() {
//        this.setFont(new Font("Sans Serif", Font.BOLD, 12));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
                repaint();
            }
        });

        System.out.println(this);

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


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

    List<House> houses = new ArrayList<House>();
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (House h:houses) {
            h.paint(g);
        }

        House onehouse = new House(objPt.x, objPt.y);
        // This paints a house at the coordinates of objPt !!!
        onehouse.paint(g);
    }

//    public void addHouse(House house) {
//        houses.add(house);
//
//        repaint();
//    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame(TITLE);
                SelectAndDragTest obj = new SelectAndDragTest();
                System.out.println(obj);
                f.add(obj);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}
