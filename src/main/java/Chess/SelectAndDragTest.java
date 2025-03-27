package Chess;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectAndDragTest extends JPanel {

    private static final String TITLE = "House";
    private static final int W = 640;
    private static final int H = 480;
//    public static Random random = new Random();
    public static Point objPt = new Point(W / 2, H / 2);
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

//        btnAdd = new JButton("Add new house");
//        btnAdd.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                house = new House(objPt.x, objPt.y);
////                addHouse(house);
//
//            }
//        });
//        this.add(btnAdd);
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
                f.add(new SelectAndDragTest());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}
