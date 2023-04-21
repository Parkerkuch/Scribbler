import java.awt.*;

/**
 * This is the draw tool class, implements all functions of the brushes for drawing
 * these are our initial variables.
 */
public class DrawTool {
    /**
     * public variable that will hold the x cord for an object
     */
    public static int xPos;
    /**
     * public variable that will hold the y cord for an object
     */
    public static int yPos;
    /**
     * public variable that will hold the width for an object
     */
    public static int width;
    /**
     * public variable that will hold the height for an object
     */
    public static int height;
    /**
     * Staic object of the DrawColor called color.
     */
    public static Color drawColor;
    /**
     * boolean varibale to check if square or round
     */
    public static boolean isSquare;

    /**
     * Sets the width and height along with the color to red.
     */
    public DrawTool() {
        setWidth(20);
        setHeight(20);
        setColor(Color.RED);
        isSquare = false;
    }


    /**
     * setter for the draw tools.
     * @param xPos sets x Position.
     */
    public void setX(int xPos){
        this.xPos = xPos;
    }

    /**
     * getter function for X
     * @return the x Positon.
     */
    public int getX(){
        return xPos;
    }

    /**
     * Setter for the Y position
     * @param yPos sets the Y Position
     */
    public void setY(int yPos){
        this.yPos = yPos;
    }

    /**
     * Getter for the Y position
     * @return return the y position
     */
    public int getY(){
        return yPos;
    }

    /**
     * sets the width by taking in the desired width
     * @param width integer of expected width
     * @throws NumberFormatException Throws exeption if width is out of bounds 0-818
     */
    public void setWidth(int width) throws NumberFormatException {
        if (width > 0 && width < 818) {
            this.width = width;
        } else {
            throw new NumberFormatException();
        }
    }

    /**
     * the getter for width
     * @return returns the width
     */
    public int getWidth(){
        return width;
    }

    /**
     * sets the height as long as int height is in bounds,
     * @param height integer of desired height
     * @throws NumberFormatException throws if out of bounds 0-818
     */
    public void setHeight(int height) throws NumberFormatException {
        if (height > 0 && height < 818) {
            this.height = height;
        } else {
            throw new NumberFormatException();
        }
    }

    /**
     * getter for the height.
     * @return returns the current height of the draw tool.
     */
    public int getHeight(){
        return height;
    }

    /**
     * sets drawColor to the current drawColor.
     * @param drawColor A color selected.
     */
    public void setColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    /**
     * getter for the current color
     * @return returns the current color.
     */
    public Color getDrawColor(){
        return drawColor;
    }

    /**
     *sets g to the draw color. and fills in g with the correct x,y width and height positions. this is for rectangle
     * objects
     * @param g Graphics object to call upon
     */
    public void paintSquare(Graphics g){
        g.setColor(drawColor);
        g.fillRect(xPos, yPos, width, height);
    }

    /**
     * this is for oval objects. Fills the color to the object (g) and then sets the position of the object.
     * @param g graphic object to call upon,
     */
    public void paintRound(Graphics g) {
        g.setColor(drawColor);
        g.fillOval(xPos, yPos, width,height);
    }

    /**
     * this is for drawing rectangles. Sets the color and positon for the draw function of rectangle.
     * @param g graphic obect to call upon
     */
    public void drawSquare(Graphics g){
        g.setColor(drawColor);
        g.drawRect(xPos, yPos, width, width);
    }



}
