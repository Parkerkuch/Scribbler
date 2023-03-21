import java.awt.*;

public class DrawTool {
    public static int xPos;
    public static int yPos;
    public static int width;
    public static int height;
    public static Color drawColor;
    public static int arcWidth;

    public static int arcHeight;

    public DrawTool() {
        //TODO: Decide on default tool dimensions
        setWidth(20);
        setHeight(20);
        setColor(Color.BLUE);
    }

    public void setX(int xPos){
        this.xPos = xPos;
    }
    public int getX(){
        return xPos;
    }
    public void setY(int yPos){
        this.yPos = yPos;
    }
    public int getY(){
        return yPos;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth(){
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight(){
        return height;
    }
    public void setArcWidth(int arcLength) {
        this.arcWidth = arcWidth;
    }
    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public Color getColor() {
        return drawColor;
    }
    public void setColor(Color drawColor) {
        this.drawColor = drawColor;
    }
    /**
     *
     * @param g Graphics object to call upon
     */
    public void paintTool(Graphics g){
        //add if statements to check for selected tool, store all in one method
        //TODO: Add if statements to check for selected tool once tools are added
        g.setColor(drawColor);
        //TODO: Come up with a way to dynamically change color
        g.fillRect(xPos, yPos, width, height);
        //TODO: Implement other shapes
    }

    /**
     *
     * @param g
     */
    /*public void paintCircle(Graphics g) {
        setWidth(10);
        setHeight(10);
        setArcWidth(100);
        setArcHeight(100);
        g.setColor(Color.BLUE);
        //g.fillRoundRect(xPos, yPos, width, height, arcWidth, arcHeight);
    }*/

}
