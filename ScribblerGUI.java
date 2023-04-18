import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ScribblerGUI extends JFrame implements ActionListener, ChangeListener {
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


    private  JButton customToolButton;
    private  JButton eraseButton;

    private JButton clearButton;

    private JButton backgroundButton;

    private Color backgroundColor;

    private JButton chiselButton;

    private JButton fineButton;

    private JButton brushButton;


    private JButton roundButton;

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

    public JSlider heightSlider;
    public JSlider widthSlider;

    public JLabel heightLabel;

    public JLabel widthLabel;


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
        backgroundColor = Color.WHITE;

        //toolbar creation
        toolbar = new JPanel();
        toolbar.setBounds(-10, 0, 849, 105);
        toolbar.setBackground(new Color(255, 255, 240));
        toolbar.setBorder(new LineBorder(new Color(192, 192, 192)));

        //toolbar components
        toolLabel = new JLabel("Tools");
        toolLabel.setBounds(106, 84, 74, 21);
        toolLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        toolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        toolLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        shapeLabel = new JLabel("Shapes");
        shapeLabel.setBounds(375, 84, 74, 21);
        shapeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        shapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shapeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        colorLabel = new JLabel("Colors");
        colorLabel.setBounds(651 , 84, 74, 21);
        colorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        colorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));


        //Canvas creation
        canvasPanel = new DrawSurface();
        canvasPanel.setBounds(10, 115, 818, 448);
        canvasPanel.setBackground(new Color(255, 255, 255));

        //additions to pane and toolbar
        scribPane.setLayout(null);
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
        barSeparator.setBounds(290, 0, 7, 105);
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
        clearButton.setBounds(250, 10, 35, 35);
        clearButton.setMargin(new Insets(0, 0, 0, 0));
        clearButton.setBackground(Color.WHITE);
        toolbar.add(clearButton);

        backgroundButton = new JButton();
        ImageIcon backgroundIcon = new ImageIcon("paintRoller_32x32.jpg");
        backgroundButton.setBounds(250, 50, 35, 35);
        backgroundButton.setMargin(new Insets(0, 0, 0, 0));
        backgroundButton.setBackground(Color.WHITE);
        backgroundButton.setIcon(backgroundIcon);
        toolbar.add(backgroundButton);

        roundButton = new JButton();
        roundButton.setBackground(Color.WHITE);
        roundButton.setBounds(36,50,35,35);
        roundButton.setVerticalAlignment(SwingConstants.CENTER);
        roundButton.setHorizontalAlignment(SwingConstants.CENTER);
        Icon roundIcon = new ImageIcon("ballPenIcon_32x32.png");
        roundButton.setMargin(new Insets(0,0,0,0));
        roundButton.setIcon(roundIcon);
        toolbar.add(roundButton);

        chiselButton = new JButton();
        chiselButton.setBounds(86, 50, 35, 35);
        chiselButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 8));
        Icon chiselIcon = new ImageIcon("chiselTip_32x32.png");
        chiselButton.setIcon(chiselIcon);
        chiselButton.setBackground(Color.WHITE);
        chiselButton.setMargin(new Insets(0,0,0,0));
        toolbar.add(chiselButton);

        fineButton = new JButton();
        fineButton.setBounds(136, 50, 35, 35);
        fineButton.setMargin(new Insets(0,0,0,0));
        Icon fineIcon = new ImageIcon("fineTip_32x32.png");
        fineButton.setBackground(Color.WHITE);
        fineButton.setIcon(fineIcon);
        toolbar.add(fineButton);

        brushButton = new JButton();
        brushButton.setBounds(136,10,35,35);
        brushButton.setBackground(Color.white);
        brushButton.setMargin(new Insets(0,0,0,0));
        Icon brushIcon = new ImageIcon("brushIcon_32x32.png");
        brushButton.setIcon(brushIcon);
        toolbar.add(brushButton);

        //Shapes Buttons
        squareButton = new JButton();
        triangleButton = new JButton();
        rectangleButton = new JButton();
        circleButton = new JButton();

        Icon squareIcon = new ImageIcon("square.png");
        squareButton.setBounds(300, 10, 40,40);
        squareButton.setMargin(new Insets(0,0,0,0));
        squareButton.setIcon(squareIcon);
        toolbar.add(squareButton);

        Icon triangleIcon = new ImageIcon("triangle.png");
        triangleButton.setBounds(350, 10, 40,40);
        triangleButton.setMargin(new Insets(0,0,0,0));
        triangleButton.setIcon(triangleIcon);
        toolbar.add(triangleButton);

        Icon rectangleIcon = new ImageIcon("rectangle.png");
        rectangleButton.setBounds(400, 10, 40,40);
        rectangleButton.setMargin(new Insets(0,0,0,0));
        rectangleButton.setIcon(rectangleIcon);
        toolbar.add(rectangleButton);

        Icon circleIcon = new ImageIcon("circle.png");
        circleButton.setBounds(450, 10, 40,40);
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




        //Action Listeners
        customToolButton.addActionListener(this);
        customColorButton.addActionListener(this);
        eraseButton.addActionListener(this);
        clearButton.addActionListener(this);
        chiselButton.addActionListener(this);
        fineButton.addActionListener(this);
        roundButton.addActionListener(this);
        brushButton.addActionListener(this);
        backgroundButton.addActionListener(this);


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


        //Creating sliders for height and width
        heightSlider = new JSlider(5, 60, 20);
        heightSlider.setBounds(186, -5, 50, 50);
        heightSlider.setBorder(new EmptyBorder(0,0,0,0));
        heightSlider.addChangeListener( this);
        heightSlider.setOpaque(false);
        toolbar.add(heightSlider);


        heightLabel = new JLabel("Height");
        heightLabel.setBounds(193,18, 50,30);
        heightLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        toolbar.add(heightLabel);

        widthSlider = new JSlider(5, 60, 20);
        widthSlider.setBounds(186, 35, 50, 50);
        widthSlider.setBorder(new EmptyBorder(0,0,0,0));
        widthSlider.addChangeListener(this);
        widthSlider.setOpaque(false);
        toolbar.add(widthSlider);

        widthLabel = new JLabel("Width");
        widthLabel.setBounds(193,58, 50,30);
        widthLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        toolbar.add(widthLabel);

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
            DrawTool.drawColor = currentColorButton.getBackground();
            DrawTool.isSquare = true;
        } else if (e.getSource() == eraseButton) {
            if (backgroundColor != Color.WHITE) {
                DrawTool.drawColor = backgroundColor;
            } else {
                DrawTool.drawColor = Color.WHITE;
            }
            //TODO: Shape Buttons
        } else if(e.getSource() == squareButton){

        } else if(e.getSource() == rectangleButton){

        } else if(e.getSource() == triangleButton){

        } else if(e.getSource() == circleButton){

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
                DrawTool.drawColor = currentColorButton.getBackground();
                DrawTool.height = 40;
                DrawTool.width = 5;
                heightSlider.setValue(40);
                widthSlider.setValue(5);
        } else if (e.getSource() == fineButton) {
            DrawTool.drawColor = currentColorButton.getBackground();
            DrawTool.height = 5;
            DrawTool.width = 5;
            heightSlider.setValue(5);
            widthSlider.setValue(5);
        } else if (e.getSource() == roundButton) {
            DrawTool.drawColor = currentColorButton.getBackground();
            DrawTool.isSquare = false;
        } else if (e.getSource() == brushButton) {
            DrawTool.drawColor = currentColorButton.getBackground();
            DrawTool.height = 25;
            DrawTool.width = 8;
            heightSlider.setValue(25);
            widthSlider.setValue(8);
        } else if (e.getSource() == backgroundButton) {
            int choice = JOptionPane.showConfirmDialog(null, "WARNING: Changing background color clears the current canvas. Would you still like to proceed?", "", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                ColorChooser cc2 = new ColorChooser();
                if (cc2.getCC() != null) {
                    backgroundColor = cc2.getCC();
                    canvasPanel.clearCanvas(Color.WHITE);
                    canvasPanel.clearCanvas(backgroundColor);
                }
            }
        }


        else if (e.getSource() == newCanvas) {
            try {
                canvasPanel.newCanvas(backgroundColor);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            backgroundColor = Color.WHITE;
        } else if (e.getSource() == clearButton) {
            canvasPanel.clearCanvas(Color.WHITE);
            canvasPanel.clearCanvas(backgroundColor);
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
                backgroundColor = Color.WHITE;
            }
        }

    /**
     *
     * @param e  a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
       DrawTool.height = heightSlider.getValue();
       DrawTool.width = widthSlider.getValue();
    }
}


