import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


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

    private final JButton customToolButton;
    private final JButton eraseButton;

    private JButton clearButton;

    public int toolHeight;
    public int toolWidth;

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

        //Separation lines for toolbar
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
        customToolButton = new JButton("Pen");
        customToolButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        customToolButton.setBounds(36, 10, 35, 35);
        customToolButton.setMargin(new Insets(0, 0, 0, 0));
        toolbar.add(customToolButton);

        eraseButton = new JButton("Erase");
        eraseButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        eraseButton.setBounds(86, 10, 35, 35);
        eraseButton.setMargin(new Insets(0, 0, 0, 0));
        toolbar.add(eraseButton);

        clearButton = new JButton("Clear");
        //Icon clearIcon = new ImageIcon("E:\editicon.PN");
        clearButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        clearButton.setBounds(136, 10, 35, 35);
        clearButton.setMargin(new Insets(0, 0, 0, 0));
        //clearButton.setIcon(clearIcon);
        toolbar.add(clearButton);

        //TODO: Add more buttons

        //Button Action Listeners
        customToolButton.addActionListener(this);
        eraseButton.addActionListener(this);
        clearButton.addActionListener(this);

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
     * @param e Button being clicked by the user
     * @method Reads ActionEvents from user
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //When user clicks, allow them to customize width and height of tool
        if (e.getSource() == customToolButton) {
            JTextField heightInput = new JTextField();
            JTextField widthInput = new JTextField();
            Object[] settings = {
                    "Height: ", heightInput,
                    "Width: ", widthInput
            };

            //Window that pops up when user clicks custom draw tool, sets user defined dimensions for tool
            //TODO: consider adding a conditional to make sure the user enters a valid input
            int option = JOptionPane.showConfirmDialog(null, settings, "Custom Tool Settings", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                toolHeight = Integer.parseInt(heightInput.getText());
                toolWidth = Integer.parseInt(widthInput.getText());
                DrawTool.height = toolHeight;
                DrawTool.width = toolWidth;
                //System.out.println("Width: " + toolWidth + ", Height: " + toolHeight);
            }
        } else if (e.getSource() == eraseButton) {
            DrawTool.drawColor = Color.WHITE;
        } else if (e.getSource() == newCanvas) {
            //TODO: New Canvas Button
        } else if (e.getSource() == clearButton) {
            repaint();
        }

        else if (e.getSource() == saveCanvas) {
            JFileChooser fc = new JFileChooser();
            int value = fc.showSaveDialog(null);
            if (value == JFileChooser.APPROVE_OPTION) {
                String filename = fc.getSelectedFile().getName();
                try {
                    canvasPanel.saveImage();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (e.getSource() == openCanvas) {
                try {
                    canvasPanel.openImage();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

