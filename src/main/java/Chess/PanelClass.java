package Chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PanelClass extends JPanel implements DropTargetListener {
//    private MyImage image;

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
    }
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
//        try {
//            text  = (String) dtde.getTransferable().getTransferData( DataFlavor.stringFlavor );
//            image = (MyImage)dtde.getTransferable().getTransferData( DataFlavor.imageFlavor );
//            this.setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED, new Color(30,60,10).brighter(), new Color(30,60,10).darker() ) );
//            dtde.dropComplete( true );
//            repaint();
//        } catch( UnsupportedFlavorException e ) {
//            e.printStackTrace();
//        } catch( IOException e ) {
//            e.printStackTrace();
//        }
//        this.setDropTarget( null );
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
