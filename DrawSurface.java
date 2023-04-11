import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//TODO: Create boolean "if drawing", then make sure if drawing is false, do not show the draw tool on the canvas (should fix cursor displaying shape problem)
//TODO: Make sure to include if exit for if mouse leaves canvas in conditional block
        //This can be done using mouse listener class (link in discord) (mousePressed/mouseClicked/mouseExited/other??)
class DrawSurface extends JPanel {
    DrawTool customTool = new DrawTool();
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
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = paintedImage.getGraphics();
        if (DrawTool.isSquare == true) {
            customTool.paintSquare(g2);
        }
        else {
            customTool.paintRound(g2);
        }
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
        JFileChooser fc = new JFileChooser();
        int value = fc.showSaveDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("filename " + file.getAbsolutePath());
            ImageIO.write(paintedImage, "png", file);

        }
    }

    /**
     * Opens image from disk
     * @throws IOException
     */
    public void openImage() throws IOException {
        //add save current image pop up
        JFileChooser fc = new JFileChooser();
        int value = fc.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            paintedImage = ImageIO.read(file);
            this.repaint();
        }
    }

    public boolean askSave() {
        boolean isSaving;
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to save your current work?", "", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            isSaving = true;
        }
        else {
            isSaving = false;
        }
        return isSaving;
    }

    public void newCanvas() throws IOException {
        if (askSave()) {
            try {
                saveImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            clearCanvas();
        }
        else {
            clearCanvas();
        }
    }
}
