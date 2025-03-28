package Chess;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

//public class DI extends JPanel
//{
//    private BufferedImage image;
//    Rectangle r;
//
//    public DI(BufferedImage image) {
//        super();
//        this.image = image;
//        r = new Rectangle(10, 10, image.getWidth(), image.getHeight());
//        this.setFocusable(true);
//    }
//
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D)g;
//
//        g2.drawImage(image, r.x, r.y, this);
//
//        //Add a border, red if picture currently has focus
//        if (isFocusOwner()) {
//            g.setColor(Color.RED);
//        } else {
//            g.setColor(Color.BLACK);
//        }
//        g2.draw(r);
//    }
//
//    public void setRect(int x, int y) {
//        r.x = x;
//        r.y = y;
//        repaint();
//    }
//
//    public BufferedImage getImage() {
//        return image;
//    }
//
//    public void setImage(BufferedImage image) {
//        this.image = image;
//        r.setSize(image.getWidth(), image.getHeight());
//    }
//
//    public static void main(String[] args) throws IOException {
//        File file = new File("./pieces/bishop-b.png");
//        BufferedImage image = ImageIO.read(file);
////        DI test = new DI(image);
////        DragHandler handler = new DragHandler(test);
////        test.addMouseListener(handler);
////        test.addMouseMotionListener(handler);
//
//        File file2 = new File("./pieces/bishop-w.png");
//        BufferedImage image2 = ImageIO.read(file2);
//        DI test2 = new DI(image2);
////        DragHandler handler2 = new DragHandler(test2);
////        test2.addMouseListener(handler2);
////        test2.addMouseMotionListener(handler2);
//
//        JFrame f = new JFrame("This is a Draggable Icon");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setContentPane(test);
//        f.setContentPane(test2);
//        f.setSize(400,400);
//        f.setLocation(200,200);
//        f.setVisible(true);
//    }
//}

//class DragHandler extends MouseInputAdapter {
//    DI di;
//    Point offset;
//    boolean dragging;
//
//    public DragHandler(DI di) {
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
