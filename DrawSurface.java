import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class DrawSurface extends JPanel {

    DrawTool redSquare = new DrawTool();

    public DrawSurface(){

        //Listener for single click
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                moveSquare(e.getX(), e.getY());
            }
        });

        //listener for Dragging
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    //moving the current drawing object
    private void moveSquare(int x, int y){
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();

        if((CURR_X != x) || (CURR_Y != y)){
            redSquare.setX(x);
            redSquare.setY(y);
            repaint(redSquare.getX(), redSquare.getY(), redSquare.getWidth(), redSquare.getHeight());

        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        redSquare.paintSquare(g);
    }
}
