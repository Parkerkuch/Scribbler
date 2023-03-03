import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScribblerGUI extends JFrame implements ActionListener {
    private final DrawSurface canvasPanel;
    private JPanel scribPane;
    private final JMenuBar menuBar;
    private final JMenu fileMenu;

    private final JMenuItem newCanvas;
    private final JMenuItem saveCanvas;
    private final JMenuItem openCanvas;
    private final JMenuItem menuEscape;

    private final JPanel toolbar;
    private final JLabel toolLabel;
    private final JLabel shapeLabel;
    private final JLabel colorLabel;

    private final JSlider zoomSlider;
    private final JLabel plusZoom;
    private final JLabel minusZoom;

    private final JButton penButton;
    private final JButton eraseButton;

    /**
     * Create the frame.
     */
    public ScribblerGUI() {
        //frame stuff
        setBackground(Color.WHITE);
        setTitle("Scribbler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 852, 680);

        //file menu stuff
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        newCanvas = new JMenuItem("New Canvas");
        fileMenu.add(newCanvas);
        newCanvas.addActionListener(this);
        saveCanvas = new JMenuItem("Save Canvas");
        fileMenu.add(saveCanvas);
        saveCanvas.addActionListener(this);
        openCanvas = new JMenuItem("Open Canvas");
        fileMenu.add(openCanvas);
        openCanvas.addActionListener(this);
        menuEscape = new JMenuItem("Exit Menu");
        menuEscape.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        fileMenu.add(menuEscape);

        //background pane for frame
        scribPane = new JPanel();
        scribPane.setBackground(new Color(230, 230, 250));
        scribPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(scribPane);

        //toolbar creation
        toolbar = new JPanel();
        toolbar.setBounds(-10, 0, 849, 105);
        toolbar.setBackground(new Color(255, 255, 240));
        toolbar.setBorder(new LineBorder(new Color(192, 192, 192)));

        //toolbar components
        toolLabel = new JLabel("Tools");
        toolLabel.setBounds(86, 84, 74, 21);
        toolLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        toolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        toolLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        shapeLabel = new JLabel("Shapes");
        shapeLabel.setBounds(355, 84, 74, 21);
        shapeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        shapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shapeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        colorLabel = new JLabel("Colors");
        colorLabel.setBounds(666, 84, 74, 21);
        colorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        colorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));


        //Zoom feature
        zoomSlider = new JSlider();
        zoomSlider.setBounds(600, 582, 200, 22);
        zoomSlider.setBorder(new EmptyBorder(0, 0, 0, 0));

        plusZoom = new JLabel("+");
        plusZoom.setBounds(804, 582, 35, 13);

        minusZoom = new JLabel("-");
        minusZoom.setBounds(545, 582, 45, 13);
        minusZoom.setHorizontalAlignment(SwingConstants.TRAILING);

        //Canvas creation
        canvasPanel = new DrawSurface();
        canvasPanel.setBounds(10, 115, 818, 448);
        canvasPanel.setBackground(new Color(255, 255, 255));

        //additions to pane and toolbar
        scribPane.setLayout(null);
        scribPane.add(minusZoom);
        scribPane.add(zoomSlider);
        scribPane.add(plusZoom);
        scribPane.add(toolbar);
        toolbar.setLayout(null);
        toolbar.add(toolLabel);
        toolbar.add(shapeLabel);
        toolbar.add(colorLabel);

        //Lines for toolbar
        JSeparator barSeparator = new JSeparator();
        barSeparator.setOrientation(SwingConstants.VERTICAL);
        barSeparator.setBackground(SystemColor.activeCaption);
        barSeparator.setForeground(SystemColor.activeCaption);
        barSeparator.setBounds(250, 0, 7, 105);
        toolbar.add(barSeparator);

        JSeparator barSeparator2 = new JSeparator();
        barSeparator2.setOrientation(SwingConstants.VERTICAL);
        barSeparator2.setForeground(SystemColor.activeCaption);
        barSeparator2.setBackground(SystemColor.activeCaption);
        barSeparator2.setBounds(528, 0, 7, 105);
        toolbar.add(barSeparator2);

        //Buttons
        penButton = new JButton("Draw");
        penButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
        penButton.setBounds(36, 10, 30, 30);
        toolbar.add(penButton);

        eraseButton = new JButton("Erase");
        eraseButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
        eraseButton.setBounds(86, 10, 30, 30);
        toolbar.add(eraseButton);

        //Button Action Listeners
        penButton.addActionListener(this);
        eraseButton.addActionListener(this);

        //Layout stuff
        scribPane.add(canvasPanel);
        GroupLayout gl_canvasPanel = new GroupLayout(canvasPanel);
        gl_canvasPanel.setHorizontalGroup(
                gl_canvasPanel.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 828, Short.MAX_VALUE)
        );
        gl_canvasPanel.setVerticalGroup(
                gl_canvasPanel.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 448, Short.MAX_VALUE)
        );
        canvasPanel.setLayout(gl_canvasPanel);
    }


    /**
     * @method Reads ActionEvents from user 
     * @param e Button being clicked by the user
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == penButton) {
        //TODO: Pen button action
        }

       else if (e.getSource() == eraseButton) {
            //TODO: Erase button action
        }

       else if (e.getSource() == newCanvas) {
       }

        else if (e.getSource() == openCanvas) {
            JFileChooser fc = new JFileChooser();
            //TODO: Open canvas action
        }

        else if (e.getSource() == saveCanvas) {
            JFileChooser fc = new JFileChooser();
            //TODO: Save canvas action
        }
    }
}

