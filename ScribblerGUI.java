import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ScribblerGUI extends JFrame implements ActionListener {
    private  DrawSurface canvasPanel;
    private JPanel scribPane;
    private  JMenuBar menuBar;
    private  JMenu fileMenu;

    private  JMenuItem newCanvas;
    private  JMenuItem saveCanvas;
    private  JMenuItem openCanvas;
    private  JMenuItem menuEscape;

    private  JPanel toolbar;
    private  JLabel toolLabel;
    private  JLabel shapeLabel;
    private  JLabel colorLabel;

    private  JSlider zoomSlider;
    private  JLabel plusZoom;
    private  JLabel minusZoom;

    private  JButton customToolButton;
    private  JButton eraseButton;

    private JButton clearButton;

    private JButton chiselButton;

    //TODO Other button ideas
    private JButton squareButton;

    private JButton rectangleButton;

    private JButton circleButton;

    private JButton triangleButton;

    private JButton redButton;
    private JButton orangeButton;
    private JButton yellowButton;
    private JButton greenButton;
    private JButton blueButton;
    private JButton magentaButton;
    private JButton blackButton;
    private JButton whiteButton;

    private JButton lightGrayButton;

    private JButton darkGrayButton;

    private JButton pinkButton;

    private JButton cyanButton;

    private JButton customColorButton;

    private JButton currentColorButton;

    //Customization values
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
        colorLabel.setBounds(651 , 84, 74, 21);
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
        customToolButton = new JButton();
        Icon drawIcon = new ImageIcon("pencilDraw_32x32.png");
        customToolButton.setBackground(Color.WHITE);
        customToolButton.setBounds(36, 10, 35, 35);
        customToolButton.setMargin(new Insets(0, 0, 0, 0));
        customToolButton.setIcon(drawIcon);
        toolbar.add(customToolButton);

        eraseButton = new JButton();
        Icon eraserIcon = new ImageIcon("Eraser_32x32.png");
        eraseButton.setBounds(86, 10, 35, 35);
        eraseButton.setMargin(new Insets(0, 0, 0, 0));
        eraseButton.setIcon(eraserIcon);
        toolbar.add(eraseButton);

        clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
        clearButton.setBounds(136, 10, 35, 35);
        clearButton.setMargin(new Insets(0, 0, 0, 0));
        clearButton.setBackground(Color.WHITE);
        toolbar.add(clearButton);

        chiselButton = new JButton("Chisel");
        chiselButton.setBounds(36, 50, 35, 35);
        chiselButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 8));
        //add chisel button icon
        chiselButton.setMargin(new Insets(0,0,0,0));
        toolbar.add(chiselButton);

        //TODO: Add more buttons

        //Shapes Buttons
        squareButton = new JButton();
        triangleButton = new JButton();
        rectangleButton = new JButton();
        circleButton = new JButton();

        Icon squareIcon = new ImageIcon("square.png");
        squareButton.setBounds(260, 10, 40,40);
        squareButton.setMargin(new Insets(0,0,0,0));
        squareButton.setIcon(squareIcon);
        toolbar.add(squareButton);

        Icon triangleIcon = new ImageIcon("triangle.png");
        triangleButton.setBounds(310, 10, 40,40);
        triangleButton.setMargin(new Insets(0,0,0,0));
        triangleButton.setIcon(triangleIcon);
        toolbar.add(triangleButton);

        Icon rectangleIcon = new ImageIcon("rectangle.png");
        rectangleButton.setBounds(360, 10, 40,40);
        rectangleButton.setMargin(new Insets(0,0,0,0));
        rectangleButton.setIcon(rectangleIcon);
        toolbar.add(rectangleButton);

        Icon circleIcon = new ImageIcon("circle.png");
        circleButton.setBounds(410, 10, 40,40);
        circleButton.setMargin(new Insets(0,0,0,0));
        circleButton.setIcon(circleIcon);
        toolbar.add(circleButton);


        //Color Buttons
        redButton = new JButton();
        orangeButton = new JButton();
        yellowButton = new JButton();
        greenButton = new JButton();
        blueButton = new JButton();
        magentaButton = new JButton();
        blackButton = new JButton();
        whiteButton = new JButton();
        cyanButton = new JButton();
        pinkButton = new JButton();
        lightGrayButton = new JButton();
        darkGrayButton = new JButton();

        customColorButton = new JButton();
        Icon customColorIcon = new ImageIcon("color-wheel_28x28.png");
        customColorButton.setMargin(new Insets(0, 0, 0, 0));
        customColorButton.setBounds(540, 5, 30,30); //y20
        customColorButton.setIcon(customColorIcon);
        toolbar.add(customColorButton);

        currentColorButton = new JButton();
        currentColorButton.setMargin(new Insets(0, 0, 0, 0));
        currentColorButton.setBounds(540, 45, 30,30);
        currentColorButton.setBackground(Color.RED);
        currentColorButton.setBorder(new LineBorder(new Color(115,115,115), 2));
        toolbar.add(currentColorButton);


        redButton.setBackground(Color.RED);
        redButton.setBounds(595, 15, 20, 20);
        toolbar.add(redButton);

        orangeButton.setBackground(Color.ORANGE);
        orangeButton.setBounds(635, 15, 20, 20);
        toolbar.add(orangeButton);

        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setBounds(675, 15, 20, 20);
        toolbar.add(yellowButton);

        greenButton.setBackground(Color.GREEN);
        greenButton.setBounds(715,15,20,20);
        toolbar.add(greenButton);

        blueButton.setBackground(Color.blue);
        blueButton.setBounds(755,15,20,20);
        toolbar.add(blueButton);

        magentaButton.setBackground(Color.MAGENTA);
        magentaButton.setBounds(595, 45, 20, 20);
        toolbar.add(magentaButton);

        blackButton.setBackground(Color.BLACK);
        blackButton.setBounds(795,45,20,20);
        toolbar.add(blackButton);

        whiteButton.setBackground(Color.WHITE);
        whiteButton.setBounds(755, 45, 20, 20);
        toolbar.add(whiteButton);

        pinkButton.setBackground(Color.PINK);
        pinkButton.setBounds(635, 45, 20, 20);
        toolbar.add(pinkButton);

        cyanButton.setBackground(Color.CYAN);
        cyanButton.setBounds(795, 15, 20, 20);
        toolbar.add(cyanButton);

        lightGrayButton.setBackground(Color.lightGray);
        lightGrayButton.setBounds(675, 45, 20, 20);
        toolbar.add(lightGrayButton);

        darkGrayButton.setBackground(Color.darkGray);
        darkGrayButton.setBounds(715, 45, 20, 20);
        toolbar.add(darkGrayButton);




        //Button Action Listeners
        customToolButton.addActionListener(this);
        customColorButton.addActionListener(this);
        eraseButton.addActionListener(this);
        clearButton.addActionListener(this);
        chiselButton.addActionListener(this);
        redButton.addActionListener(this);
        orangeButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        magentaButton.addActionListener(this);
        blackButton.addActionListener(this);
        whiteButton.addActionListener(this);
        pinkButton.addActionListener(this);
        cyanButton.addActionListener(this);
        lightGrayButton.addActionListener(this);
        darkGrayButton.addActionListener(this);
        squareButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        triangleButton.addActionListener(this);
        circleButton.addActionListener(this);


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
            Object[] penSettings = {
                    "Height: ", heightInput,
                    "Width: ", widthInput,
            };

            //Window that pops up when user clicks custom draw tool, sets user defined dimensions for tool
            //TODO: consider adding a conditional to make sure the user enters a valid input
            int option = JOptionPane.showConfirmDialog(null, penSettings, "Custom Tool Settings", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    toolHeight = Integer.parseInt(heightInput.getText());
                    toolWidth = Integer.parseInt(widthInput.getText());
                    DrawTool.height = toolHeight;
                    DrawTool.width = toolWidth;
                    DrawTool.drawColor = Color.RED;

                    if (toolHeight <= 0 || toolHeight >= 818) {
                        JOptionPane.showMessageDialog(null, "Enter a valid height");
                    }
                    if (toolWidth <= 0 || toolHeight >= 818) {
                        JOptionPane.showMessageDialog(null, "Enter a valid width");
                    }

                    //System.out.println("Width: " + toolWidth + ", Height: " + toolHeight);
                }
                catch (NumberFormatException n){
                    JOptionPane.showMessageDialog(null, "Enter a valid integer");
                }
            }
        } else if (e.getSource() == eraseButton) {
            JTextField heightInput = new JTextField();
            JTextField widthInput = new JTextField();
            int toolHeight;
            int toolWidth;

            Object[] eraserSettings = {
                    "Height: ", heightInput,
                    "Width: ", widthInput
            };

            int option = JOptionPane.showConfirmDialog(null, eraserSettings, "Eraser Settings", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    toolHeight = Integer.parseInt(heightInput.getText());
                    toolWidth = Integer.parseInt(widthInput.getText());
                    DrawTool.height = toolHeight;
                    DrawTool.width = toolWidth;
                    DrawTool.drawColor = Color.WHITE;
                    //System.out.println("Width: " + toolWidth + ", Height: " + toolHeight);
                    //TODO: Whenever user enters invalid input, the window closes, we need to keep it open and just reask for input
                    if (toolHeight <= 0 || toolHeight >= 818) {
                        JOptionPane.showMessageDialog(null, "Enter a valid height");
                    }
                    if (toolWidth <= 0 || toolHeight >= 818) {
                        JOptionPane.showMessageDialog(null, "Enter a valid width");
                    }
                }
                catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Enter a valid integer");
                }
            }
        } else if(e.getSource() == squareButton){
            DrawTool.drawColor = Color.BLACK;
            DrawTool.height = 50;
            DrawTool.width = 50;

        } else if(e.getSource() == rectangleButton){
            DrawTool.drawColor = Color.BLACK;
            DrawTool.height = 30;
            DrawTool.width = 50;

        } else if(e.getSource() == triangleButton){
            DrawTool.drawColor = Color.BLACK;

        } else if(e.getSource() == circleButton){
            DrawTool.drawColor = Color.BLACK;
            DrawTool.height = 50;
            DrawTool.width = 50;

        } else if (e.getSource() == redButton) {
            DrawTool.drawColor = Color.RED;
            currentColorButton.setBackground(Color.RED);
        } else if (e.getSource() == orangeButton) {
            DrawTool.drawColor = Color.ORANGE;
            currentColorButton.setBackground(Color.ORANGE);
        } else if (e.getSource() == greenButton) {
            DrawTool.drawColor = Color.GREEN;
            currentColorButton.setBackground(Color.GREEN);
        } else if (e.getSource() == blueButton) {
            DrawTool.drawColor = Color.BLUE;
            currentColorButton.setBackground(Color.BLUE);
        } else if (e.getSource() == yellowButton) {
            DrawTool.drawColor = Color.YELLOW;
            currentColorButton.setBackground(Color.YELLOW);
        } else if (e.getSource() == magentaButton) {
            DrawTool.drawColor = Color.MAGENTA;
            currentColorButton.setBackground(Color.MAGENTA);
        } else if (e.getSource() == blackButton) {
            DrawTool.drawColor = Color.BLACK;
            currentColorButton.setBackground(Color.BLACK);
        } else if (e.getSource() == whiteButton) {
            DrawTool.drawColor = Color.WHITE;
            currentColorButton.setBackground(Color.WHITE);
        } else if (e.getSource() == pinkButton) {
            DrawTool.drawColor = Color.PINK;
            currentColorButton.setBackground(Color.PINK);
        } else if (e.getSource() == cyanButton) {
            DrawTool.drawColor = Color.CYAN;
            currentColorButton.setBackground(Color.CYAN);
        } else if (e.getSource() == lightGrayButton) {
            DrawTool.drawColor = Color.lightGray;
            currentColorButton.setBackground(Color.lightGray);
        } else if (e.getSource() == darkGrayButton) {
            DrawTool.drawColor = Color.darkGray;
            currentColorButton.setBackground(Color.darkGray);
        } else if (e.getSource() == customColorButton) {
            ColorChooser cc = new ColorChooser();
            if (cc.getCC() != null) {
                DrawTool.drawColor = cc.getCC();
                currentColorButton.setBackground(cc.getCC());
            }

        } else if (e.getSource() == chiselButton) {
            DrawTool.height = 40;
            DrawTool.width = 5;
        }


        else if (e.getSource() == newCanvas) {
            //TODO: New Canvas Button
        } else if (e.getSource() == clearButton) {
            canvasPanel.clearCanvas(Color.WHITE);
        }

        else if (e.getSource() == saveCanvas) {
                try {
                    canvasPanel.saveImage();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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

