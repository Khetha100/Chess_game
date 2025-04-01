package Chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelClass extends JPanel {

    private static final int W = 512;
    private static final int H = 512;
    Rectangle r;
    Image image = null;


//    public static Point objPt = new Point(W / 2, H / 2);
    List<Point> ptList = new ArrayList<>();
    private Point mousePt;

    public PanelClass() {


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
//                    objPt.setLocation(objPt.x + dx, objPt.y + dy);

                    mousePt = e.getPoint();
                    repaint();
                }
            });
    }

    public PanelClass(Image image) {
        super();
        this.image = image;
        r = new Rectangle(10, 10, image.getWidth(this), image.getHeight(this));
        this.setFocusable(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }


    public void setRect(int x, int y) {
        r.x = x;
        r.y = y;
        repaint();
    }

    @Override
    public void paint(Graphics g){

        boolean white = true;
        for (int i = 0;i<8;i++){
            for (int j = 0; j<8;j++){

                if (white) {
                    if (checkSpaceFilling(i * 64, j * 64) != null) {

                        File sourceimage = new File("./pieces/" + checkSpaceFilling(i * 64, j * 64));

                        try {
                            image = ImageIO.read(sourceimage);
                            g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, this);
                            PanelClass test = new PanelClass(image);
                            DragHandler handler = new DragHandler(test);
                            test.addMouseListener(handler);
                            test.addMouseMotionListener(handler);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    g.setColor(Color.white.darker());

                }
                else{
                    g.fillRect(i*64,j*64,64,64);
                    if (checkSpaceFilling(i * 64, j * 64) != null) {
                        File sourceimage = new File("./pieces/" + checkSpaceFilling(i * 64, j * 64));

                        try {
                            image = ImageIO.read(sourceimage);
                            g.drawImage(image.getScaledInstance(64, 64, 64), i * 64, j * 64, this);
                            PanelClass test = new PanelClass(image);
                            DragHandler handler = new DragHandler(test);
                            test.addMouseListener(handler);
                            test.addMouseMotionListener(handler);

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
        return null;

    }
}


class DragHandler extends MouseInputAdapter {
    PanelClass di;
    Point offset;
    boolean dragging;

    public DragHandler(PanelClass di) {
        this.di = di;
        offset = new Point();
        dragging = false;
    }

    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        if(di.r.contains(p)) {
            offset.x = p.x - di.r.x;
            offset.y = p.y - di.r.y;
            dragging = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;
    }

    public void mouseDragged(MouseEvent e) {
        if(dragging) {
            int x = e.getX() - offset.x;
            int y = e.getY() - offset.y;
            di.setRect(x, y);
        }
    }
}