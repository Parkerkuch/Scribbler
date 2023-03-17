import java.awt.*;

public class DrawTool {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private int arcWidth;

    private int arcHeight;

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

    /**
     *
     * @param g
     */
    public void paintSquare(Graphics g){
        //setX(50);
        //setY(50);
        setWidth(20);
        setHeight(5);
        g.setColor(Color.RED); //Color setting
        g.fillRect(xPos, yPos, width, height); //draws RECTANGLE CURRENTLY
    }

    /**
     *
     * @param g
     */
    public void paintCircle(Graphics g) {
        //setX(50);
        //setY(50);
        setWidth(10);
        setHeight(10);
        setArcWidth(100);
        setArcHeight(100);
        g.setColor(Color.BLUE);
        //g.fillRoundRect(xPos, yPos, width, height, arcWidth, arcHeight);
    }

}
