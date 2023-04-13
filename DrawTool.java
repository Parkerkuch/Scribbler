import java.awt.*;

public class DrawTool {
    public static int xPos;
    public static int yPos;
    public static int width;
    public static int height;
    public static Color drawColor;
    public static boolean isSquare;

    public DrawTool() {
        setWidth(20);
        setHeight(20);
        setColor(Color.RED);
        isSquare = false;
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

    public void setColor(Color drawColor) {
        this.drawColor = drawColor;
    }
    /**
     *
     * @param g Graphics object to call upon
     */
    public void paintSquare(Graphics g){
        g.setColor(drawColor);
        g.fillRect(xPos, yPos, width, height);
    }

    public void paintRound(Graphics g) {
        g.setColor(drawColor);
        g.fillOval(xPos, yPos, width,height);
    }

    public void drawSquare(Graphics g){
        g.setColor(drawColor);
        g.drawRect(xPos, yPos, width, width);
    }



}
