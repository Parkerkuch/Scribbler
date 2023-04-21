import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class DrawSurface extends JPanel {


    DrawTool customTool = new DrawTool();


    static BufferedImage paintedImage = new BufferedImage(852, 680, BufferedImage.TYPE_INT_ARGB);

    /**
     * boolean variable that will check to see if it is drawing or not.
     */
    public boolean isDrawing;






    /**
     * Constructor for creating a Draw Surface
     */
    public DrawSurface(){
        //Listener for single click
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                isDrawing = true;
                moveTool(e.getX(), e.getY());
            }
        });


        //listener for Dragging
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                isDrawing = true;
                moveTool(e.getX(), e.getY());
            }
        });


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                isDrawing = false;
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                isDrawing = false;
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
            if (isDrawing == true) {
                customTool.setX(x);
                customTool.setY(y);
                repaint(customTool.getX(), customTool.getY(), customTool.getWidth(), customTool.getHeight());
            }
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
            if (isDrawing == true)
                customTool.paintSquare(g2);
        }
        else {
            if (isDrawing == true)
                customTool.paintRound(g2);
        }
        g.drawImage(paintedImage, 0, 0, null);

    }


    /**
     * function clears the canvas and sets it to back round color (bg)
     * @param bg is the backround color
     */
    public void clearCanvas(Color bg) {
        Graphics g = paintedImage.getGraphics();
        g.setColor(bg);
        g.fillRect(0,0,852,680);
        repaint();
    }


    /**
     * Saves image to disk
     * @throws IOException
     */
    public boolean saveImage() throws IOException {
        JFileChooser fc = new JFileChooser();
        int value = fc.showSaveDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ImageIO.write(paintedImage, "png", file);
            return true;
        }
        else {
            return false;
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

    /**
     * checks to see if the file is correctly saving
     * @return returns a boolean true, if the file is saving
     * false, if the file is not
     */
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


    /**
     * creating a new canvas, sets the backround color for the new canvas.
     * @param bg is the new backround color being set on the canvas
     * @throws IOException checks of the file is saved or not. If runtime exception it will throw an error.
     */
    public void newCanvas(Color bg) throws IOException {
        if (askSave()) {
            boolean saveRet;
            try {
                saveRet = saveImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if (saveRet == true) {
                clearCanvas(Color.WHITE);
            }
        }
        else {
            clearCanvas(Color.WHITE);
        }
    }


}
