import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ScribblerGUI extends JPanel{

    //main window
    private JFrame scribFrame;

    //Panel for each section
    private JPanel tools;
    private JPanel shapes;
    private JPanel colors;
    private JPanel canvas;

    private JPanel toolbar;

    //labels for panels
    private JLabel toolLabel;
    private JLabel shapeLabel;
    private JLabel colorLabel;
    private JLabel sizeLabel;
    // todo: add more labels for current selected options?

    //for open/save/new canvas
    private JMenu fileMenu;
    private JMenuItem newCanvas;
    private JMenuItem saveItem;
    private JMenuItem openItem;

    //TODO: private ButtonListener buttonListener; ??

    //JButtons for tools
    private JButton draw;
    private JButton eraser;
    private JButton bucket;

    //TODO: shape buttons?

    //TODO: color implementation

    /**
     * Constructor for GUI
     */
    public ScribblerGUI() {
        create();
    }

    /**
     * Method to create the GUI
     */
    public void create() {
        //create frame
        scribFrame = new JFrame("Scribbler");
        scribFrame.setPreferredSize(new Dimension(850, 650));
        //todo: figure out how to properly implement layout
        //scribFrame.setLayout(new GridLayout(2,4));
        scribFrame.setResizable(false);
        scribFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Panels
        toolbar = new JPanel();
        tools = new JPanel();
        shapes = new JPanel();
        colors = new JPanel();
        canvas = new JPanel();

        //PanelLabels
        toolLabel = new JLabel("Tools");
        shapeLabel = new JLabel("Shapes");
        colorLabel = new JLabel("Colors");
        tools.add(toolLabel);
        shapes.add(shapeLabel);
        colors.add(colorLabel);

        //Add Panels to frame
        scribFrame.add(toolbar); //north position?
        toolbar.add(tools);
        toolbar.add(shapes);
        toolbar.add(colors);
        scribFrame.add(canvas); //south position?


        //Border creation and implementation for canvas
        Border blackline = BorderFactory.createLineBorder(Color.black);
        canvas.setSize( new Dimension(850, 600));
        canvas.setBorder(blackline);

        toolbar.setSize(new Dimension(850,50));
        toolbar.setBorder(blackline);


        //fileMenu
        fileMenu = new JMenu("File");
        newCanvas = new JMenuItem("New Canvas");
        saveItem = new JMenuItem("Save Canvas");
        openItem = new JMenuItem("Open Canvas");

        fileMenu.add(newCanvas);
        fileMenu.add(saveItem);
        fileMenu.add(openItem);

        //Action Listeners for Menu
        //newCanvas.addActionListener(buttonListener::<action>);
        //saveItem.addActionListener(buttonListener::<action>);
        //openItem.addActionListener(buttonListener::<action>);

        //Creates menu to hold fileMenu
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        scribFrame.setJMenuBar(menuBar);


        scribFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scribFrame.pack();
        scribFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ScribblerGUI scrib = new ScribblerGUI();
    }
}
