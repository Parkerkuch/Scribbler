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
    public void setWidth(int width) throws NumberFormatException {
        if (width > 0 && width < 818) {
            this.width = width;
        } else {
            throw new NumberFormatException();
        }
    }
    public int getWidth(){
        return width;
    }
    public void setHeight(int height) throws NumberFormatException {
        if (height > 0 && height < 818) {
            this.height = height;
        } else {
            throw new NumberFormatException();
        }
    }

    public int getHeight(){
        return height;
    }

    public void setColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public Color getDrawColor(){
        return drawColor;
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
