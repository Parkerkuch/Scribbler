import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class DrawSurface extends JPanel {
    DrawTool redSquare = new DrawTool();
    BufferedImage paintedImage = new BufferedImage(818, 448, BufferedImage.TYPE_INT_ARGB);
    public DrawSurface(){

        //Listener for single click
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                moveSquare(e.getX(), e.getY());
            }
        });

        //listener for Dragging
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    //moving the current drawing object
    private void moveSquare(int x, int y){
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();

        if((CURR_X != x) || (CURR_Y != y)){
            redSquare.setX(x);
            redSquare.setY(y);
            repaint(redSquare.getX(), redSquare.getY(), redSquare.getWidth(), redSquare.getHeight());
        }
    }

@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        redSquare.paintSquare(g);
        g.drawImage(paintedImage, 0, 0, null);
    }

    public void save() throws IOException {
        System.out.println("Save executed");
        //add ability to interact with file explorer and save to disk
        ImageIO.write(paintedImage, "PNG", new File("filename.png"));
    }

    public void open() throws IOException {
        System.out.println("Open executed");
        //add ability to interact with file explorer and open from disk
        paintedImage = ImageIO.read(new File("filename.png"));
        // update panel with new paint image
        repaint();
    }
}
