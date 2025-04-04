package Chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//public class PanelClass extends JPanel {
//
//    private static final int W = 512;
//    private static final int H = 512;
////    Rectangle r;
//    Image image = null;


//    public static Point objPt = new Point(64 / 2, 64 / 2);
//    List<Point> ptList = new ArrayList<>();
//    private Point mousePt;
//
//    public PanelClass() {
//
//
//            this.addMouseListener(new MouseAdapter() {
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    mousePt = e.getPoint();
//                    repaint();
//                }
//            });
//
//        System.out.println(this);
//            this.addMouseMotionListener(new MouseMotionAdapter() {
//
//                @Override
//                public void mouseDragged(MouseEvent e) {
//                    int dx = e.getX() - mousePt.x;
//                    int dy = e.getY() - mousePt.y;
//                    objPt.setLocation(objPt.x + dx, objPt.y + dy);
//
//                    mousePt = e.getPoint();
//                    repaint();
//                }
//            });
//    }
//
//
//
//
////    public PanelClass(Image image) {
////        super();
////        this.image = image;
////        r = new Rectangle(10, 10, image.getWidth(this), image.getHeight(this));
////        this.setFocusable(true);
////    }
//
//
//
//    List<Piece> pieces = new ArrayList<Piece>();
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Piece h:pieces) {
//            h.paint(g);
//        }
//
//        Piece piece = new Piece(objPt.x, objPt.y);
//        // This paints a house at the coordinates of objPt !!!
//        piece.paint(g);
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(W, H);
//    }


//    public void setRect(int x, int y) {
//        r.x = x;
//        r.y = y;
//        repaint();
//    }

//    @Override
//    public void paint(Graphics g){
//
//        boolean white = true;
//        for (int i = 0;i<8;i++){
//            for (int j = 0; j<8;j++){

//
//                if (white) {
//                    if (checkSpaceFilling(i * 64, j * 64) != null) {
//
//                        File sourceimage = new File("./pieces/" + checkSpaceFilling(i * 64, j * 64));
//
//                        try {
//                            image = ImageIO.read(sourceimage);
//
//                            g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, this);
////                            PanelClass test = new PanelClass(image);
////                            DragHandler handler = new DragHandler(test);
////
////                            test.addMouseListener(handler);
////                            test.addMouseMotionListener(handler);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    g.setColor(Color.white.darker());
//
//                }
//                else{
//                    g.fillRect(i*64,j*64,64,64);
//                    if (checkSpaceFilling(i * 64, j * 64) != null) {
//                        File sourceimage = new File("./pieces/" + checkSpaceFilling(i * 64, j * 64));
//
//                        try {
//                            image = ImageIO.read(sourceimage);
//                            g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, this);
////                            PanelClass test = new PanelClass(image);
////                            DragHandler handler = new DragHandler(test);
////                            test.addMouseListener(handler);
////                            test.addMouseMotionListener(handler);
//
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//
//                    g.setColor(Color.gray.darker());
//
//
//                }
//
//
//                white=!white;
//            }
//            white =!white;
//        }
//    }




//}


//class DragHandler extends MouseInputAdapter {
//    PanelClass di;
//    Point offset;
//    boolean dragging;
//
//    public DragHandler(PanelClass di) {
//        this.di = di;
//        offset = new Point();
//        dragging = false;
//    }
//
//    public void mousePressed(MouseEvent e) {
//        Point p = e.getPoint();
//        if(di.r.contains(p)) {
//            offset.x = p.x - di.r.x;
//            offset.y = p.y - di.r.y;
//            dragging = true;
//        }
//    }
//
//    public void mouseReleased(MouseEvent e) {
//        dragging = false;
//    }
//
//    public void mouseDragged(MouseEvent e) {
//        if(dragging) {
//            int x = e.getX() - offset.x;
//            int y = e.getY() - offset.y;
//            di.setRect(x, y);
//        }
//    }
//}


//        package Chess;

//import javax.swing.*;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;

public class PanelClass extends JPanel {

    private static final String TITLE = "House";
    private static final int W = 512;
    private static final int H = 512;
    //    public static Random random = new Random();
    public static Point objPt = new Point(0, 0);
    private Point mousePt;
//    House house;
//    public static JButton btnAdd;

    public PanelClass() {
//        this.setFont(new Font("Sans Serif", Font.BOLD, 12));m
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
                repaint();
            }
        });

//        System.out.println(this);

        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = Math.abs(e.getX() - mousePt.x);
                int dy = Math.abs(e.getY() - mousePt.y);
                System.out.println(dx);
                System.out.println(dy);
                objPt.setLocation(objPt.x + dx, objPt.y + dy);
//                System.out.println(objPt.x);
//                System.out.println(objPt.y);
                mousePt = e.getPoint();
                repaint();
            }
        });

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

    List<Piece> houses = new ArrayList<Piece>();
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Piece h:houses) {
            h.paint(g);
        }

        boolean white = true;
//        for (int i = 0;i<8;i++){
//            for (int j = 0; j<8;j++) {

                if (white) {

//                    System.out.println(objPt.x);
//                    System.out.println(objPt.y);
//                    objPt = new Point(0,0);
                    Piece onehouse = new Piece(objPt.x, objPt.y);
//                Piece onehouse = new Piece(i * 64, j * 64);
                    // This paints a house at the coordinates of objPt !!!
                    g.setColor(Color.white.darker());
                    onehouse.paint(g);

                }
                else{
                    g.fillRect(64,64,64,64);
//                    objPt = new Point(0,0);
                    Piece onehouse = new Piece(objPt.x, objPt.y);
//                Piece onehouse = new Piece(i * 64, j * 64);
                    // This paints a house at the coordinates of objPt !!!
                    g.setColor(Color.gray.darker());
                    onehouse.paint(g);

                }
                white=!white;

//            }
//            white =!white;
//        }
    }



//    public void addHouse(House house) {
//        houses.add(house);
//
//        repaint();
//    }


//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame f = new JFrame(TITLE);
//                PanelClass obj = new PanelClass();
//                System.out.println(obj);
//                f.add(obj);
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.pack();
//                f.setLocationRelativeTo(null);
//                f.setVisible(true);
//            }
//        });
//    }
}
