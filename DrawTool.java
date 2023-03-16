import java.awt.*;

public class DrawTool {
    private int xPos = 50;
    private int yPos = 50;
    private int width = 20;
    private int height = 5;

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
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    /**
     *
     * @param g
     */
    public void paintSquare(Graphics g){
        g.setColor(Color.RED); //Color setting
        g.fillRect(xPos, yPos, width, height); //draws RECTANGLE CURRENTLY
    }

    /**
     *
     * @param g
     */
    public void paintCircle(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(xPos, yPos, width, height);
    }

}
