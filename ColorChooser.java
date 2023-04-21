// Java program to implement JColorChooser
// class using ActionListener
import java.awt.*;
import javax.swing.*;

/**
 * colorChooser extends JFrame
 */
public class ColorChooser extends
        JFrame {
    /**
     * initialColor Variable
     */
    public Color initialColor;
    /**
     * newColor variable
     */
    public Color newColor;

    /**
     * Constructor for color chooser pane
     */
    ColorChooser() {
        initialColor = DrawTool.drawColor;

        newColor = JColorChooser.showDialog(this,
                "Select a color", initialColor);

        }

    /**
     *
     * @return New color selected by user
     */
    public Color getCC() {
        return newColor;
    }

}