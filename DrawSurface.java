import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Path;

//TODO: Create boolean "if drawing", then make sure if drawing is false, do not show the draw tool on the canvas (should fix cursor displaying shape problem)
//TODO: Make sure to include if exit for if mouse leaves canvas in conditional block
        //This can be done using mouse listener class (link in discord) (mousePressed/mouseClicked/mouseExited/other??)
class DrawSurface extends JPanel {
    DrawTool customTool = new DrawTool();
    //DrawTool circle = new DrawTool();
    BufferedImage paintedImage = new BufferedImage(852, 680, BufferedImage.TYPE_INT_ARGB);


    /**
     * Constructor for creating a Draw Surface
     */
    public DrawSurface(){
        //Listener for single click
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                moveTool(e.getX(), e.getY());
            }
        });

        //listener for Dragging
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                moveTool(e.getX(), e.getY());
            }
        });
    }

    /**
     * @param x = coordinate x corresponding to location on canvas in width
     * @param y = coordinate y corresponding to location on canvas in height
     */
    private void moveTool(int x, int y){
        //if for checking if boolean for mouseReleased/Pressed
        final int CURR_X = customTool.getX();
        final int CURR_Y = customTool.getY();

        if((CURR_X != x) || (CURR_Y != y)){
            customTool.setX(x);
            customTool.setY(y);
            repaint(customTool.getX(), customTool.getY(), customTool.getWidth(), customTool.getHeight());
        }
    }


    /**
     *
     * @param x
     * @param y
     */
    /*private void moveCircle(int x, int y) {
        final int CURR_X = circle.getX();
        final int CURR_Y = circle.getY();

        if((CURR_X != x) || (CURR_Y != y)){
            circle.setX(x);
            circle.setY(y);
            repaint(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
        }
    }*/

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = paintedImage.getGraphics();
        customTool.paintTool(g2);
        g.drawImage(paintedImage, 0, 0, null);
    }

    public void clearCanvas() {
        paintedImage = new BufferedImage(852, 680, BufferedImage.TYPE_INT_ARGB);
        repaint();
    }

    /**
     * Saves image to disk
     * @throws IOException
     */
    public void saveImage() throws IOException {
        System.out.println("Save executed");
        //add ability to interact with file explorer and save to disk

        JFileChooser fc = new JFileChooser();
        int value = fc.showSaveDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("filename " + file.getAbsolutePath());
            ImageIO.write(paintedImage, "png", file);
            System.out.println("all saved");

        }
    }

    /**
     * Opens image from disk
     * @throws IOException
     */
    public void openImage() throws IOException {
        System.out.println("Open executed");
        //add ability to interact with file explorer and open from disk
        JFileChooser fc = new JFileChooser();
        int value = fc.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            paintedImage = ImageIO.read(file);
            this.repaint();
        }
    }

    public void newCanvas() throws IOException {

    }
}
