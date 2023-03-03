import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class DrawSurface extends JPanel {

    DrawTool redSquare = new DrawTool();

    public DrawSurface(){
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setOpaque(true);
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                moveSquare(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    private void moveSquare(int x, int y){
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();
        final int CURR_W = redSquare.getWidth();
        final int CURR_H = redSquare.getHeight();
        final int OFFSET = 1;

        if((CURR_X != x) || (CURR_Y != y)){
            //repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

            redSquare.setX(x);
            redSquare.setY(y);

            repaint(redSquare.getX(), redSquare.getY(), redSquare.getWidth() + OFFSET, redSquare.getHeight() + OFFSET);

        }
    }
   /* public Dimension getPreferredSize(){
        return new Dimension(850, 550);
    }
    */
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        redSquare.paintSquare(g);

    }
}
