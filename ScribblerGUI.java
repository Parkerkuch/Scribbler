import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;

public class ScribblerGUI extends JFrame {

    private JPanel scribPane;

    /**
     * Launch the application.
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

    /**
     * Create the frame.
     */
    public ScribblerGUI() {
        setBackground(Color.WHITE);
        setTitle("Scribbler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 852, 680);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newCanvas = new JMenuItem("New Canvas");
        fileMenu.add(newCanvas);

        JMenuItem saveCanvas = new JMenuItem("Save Canvas");
        fileMenu.add(saveCanvas);

        JMenuItem openCanvas = new JMenuItem("Open Canvas");
        fileMenu.add(openCanvas);

        JMenuItem menuEscape = new JMenuItem("Exit Menu");
        menuEscape.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        fileMenu.add(menuEscape);
        scribPane = new JPanel();
        scribPane.setBackground(new Color(230, 230, 250));
        scribPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(scribPane);

        JPanel toolbar = new JPanel();
        toolbar.setBounds(-10, 0, 849, 105);
        toolbar.setBackground(new Color(255, 255, 240));
        toolbar.setBorder(new LineBorder(new Color(192, 192, 192)));

        JLabel toolLabel = new JLabel("Tools");
        toolLabel.setBounds(86, 84, 74, 21);
        toolLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        toolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        toolLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        JLabel shapeLabel = new JLabel("Shapes");
        shapeLabel.setBounds(355, 84, 74, 21);
        shapeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        shapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shapeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        JLabel colorLabel = new JLabel("Colors");
        colorLabel.setBounds(666, 84, 74, 21);
        colorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        colorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        JSlider zoomSlider = new JSlider();
        zoomSlider.setBounds(600, 582, 200, 22);
        zoomSlider.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel plusZoom = new JLabel("+");
        plusZoom.setBounds(804, 582, 35, 13);

        JLabel minusZoom = new JLabel("-");
        minusZoom.setBounds(545, 582, 45, 13);
        minusZoom.setHorizontalAlignment(SwingConstants.TRAILING);

        JPanel canvasPanel = new JPanel();
        canvasPanel.setBounds(10, 115, 818, 448);
        canvasPanel.setBackground(new Color(255, 255, 255));
        scribPane.setLayout(null);
        scribPane.add(minusZoom);
        scribPane.add(zoomSlider);
        scribPane.add(plusZoom);
        scribPane.add(toolbar);
        toolbar.setLayout(null);
        toolbar.add(toolLabel);
        toolbar.add(shapeLabel);
        toolbar.add(colorLabel);

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
}
