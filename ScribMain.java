import java.awt.*;

/**
 * This is the main method to run the whole scribbler program.
 */
public class ScribMain {
    /**
     * The main method, makes an event queue to runnable and calls the GUI class
     * @param args runs the program
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScribblerGUI frame = new ScribblerGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
