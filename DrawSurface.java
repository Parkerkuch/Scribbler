import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class DrawSurface extends JPanel {
    DrawTool redSquare = new DrawTool();
    DrawTool circle = new DrawTool();
    BufferedImage paintedImage = new BufferedImage(818, 448, BufferedImage.TYPE_INT_ARGB);

    /**
     *
     */
    public DrawSurface(){

        //Listener for single click
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                moveSquare(e.getX(), e.getY());
                //moveCircle(e.getX(), e.getY());
            }
        });

        //listener for Dragging
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                moveSquare(e.getX(), e.getY());
                //moveCircle(e.getX(), e.getY());
            }
        });
    }

    /**
     *
     * @param x
     * @param y
     */
    private void moveSquare(int x, int y){
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();

        if((CURR_X != x) || (CURR_Y != y)){
            redSquare.setX(x);
            redSquare.setY(y);
            repaint(redSquare.getX(), redSquare.getY(), redSquare.getWidth(), redSquare.getHeight());
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    private void moveCircle(int x, int y) {
        final int CURR_X = circle.getX();
        final int CURR_Y = circle.getY();

        if((CURR_X != x) || (CURR_Y != y)){
            circle.setX(x);
            circle.setY(y);
            repaint(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
        }
    }

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        redSquare.paintSquare(g);
        //circle.paintCircle(g);
        g.drawImage(paintedImage, 0, 0, null);
    }

    /**
     *
     * @throws IOException
     */
    public void saveImage() throws IOException {
        System.out.println("Save executed");
        //add ability to interact with file explorer and save to disk

        JFileChooser fc = new JFileChooser();
        int value = fc.showSaveDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            ImageIO.write(paintedImage, "png", new File(filename));
        }
    }

    /**
     *
     * @throws IOException
     */
    public void openImage() throws IOException {
        System.out.println("Open executed");
        //add ability to interact with file explorer and open from disk
        JFileChooser fc = new JFileChooser();
        int value = fc.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            paintedImage = ImageIO.read(new File(filename));
        }
        // update panel with new paint image
        //repaint(); //we can use repaint to clear the canvas and will be usefull in creating new canvas
    }
}
