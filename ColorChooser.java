// Java program to implement JColorChooser
// class using ActionListener
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ColorChooser extends
        JFrame {

    public Color initialColor;
    public Color newColor;
    // Constructor
    ColorChooser() {
        initialColor = DrawTool.drawColor;

        newColor = JColorChooser.showDialog(this,
                "Select a color", initialColor);

        }
    public Color getCC() {
        return newColor;
    }

}