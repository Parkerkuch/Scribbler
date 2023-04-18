// Java program to implement JColorChooser
// class using ActionListener
import java.awt.*;
import javax.swing.*;

public class ColorChooser extends
        JFrame {

    public Color initialColor;
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