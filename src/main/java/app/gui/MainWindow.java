package app.gui;

//Java Swing
import javax.swing.*;
import java.awt.*;

public class MainWindow {
    //Constants:
    public static final int WINDOW_WIDTH = 370, WINDOW_HEIGHT = 500;
    public static final String WINDOW_ICON_PATH = "./assets/img/icon.png";

    //Variables:
    private JButton convertBtn;
    private JComboBox<String> convertFromCB, convertToCB;
    private JFrame mainFrame;
    private JTextField inputJT, outputJT;

    /**
     * Constructs a main window object.
     */
    public MainWindow() {
        initializeMainFrame();
        initializeComboBoxes();

}

    /**
     * It creates a totally new JFrame object.
     * That object is set to the main frame variable.
     */
    private void initializeMainFrame() {
        this.mainFrame = new JFrame("Number System Converter");

        this.mainFrame.setLayout(null);
        this.mainFrame.setResizable(false);
        this.mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.mainFrame.setSize(MainWindow.WINDOW_WIDTH, MainWindow.WINDOW_HEIGHT);
        this.mainFrame.setIconImage(new ImageIcon(MainWindow.WINDOW_ICON_PATH).getImage());
    }

    private void initializeComboBoxes() {
        Font titleFont = new Font("", Font.PLAIN, 17);
        Font CBFont = new Font("", Font.BOLD, 13);

        //Convert From Combo Box
        JLabel convertFromLabel = new JLabel("Convert From");
        convertFromLabel.setBounds(30, 10, 100, 30);
        convertFromLabel.setFont(titleFont);

        this.convertFromCB = new JComboBox<>();
        this.convertFromCB.setBounds(30, 40, 120, 30);
        this.convertFromCB.setFont(CBFont);
        this.convertFromCB.addItem("Base-2");


        //Convert To Combo Box
        JLabel convertToLabel = new JLabel("Convert To");
        convertToLabel.setBounds(200, 10, 100, 30);
        convertToLabel.setFont(titleFont);

        this.convertToCB = new JComboBox<>();
        this.convertToCB.setBounds(200, 40, 120, 30);
        this.convertToCB.setFont(CBFont);


        //Adds GUI components to the frame.
        this.mainFrame.add(convertFromLabel);
        this.mainFrame.add(this.convertFromCB);
        this.mainFrame.add(convertToLabel);
        this.mainFrame.add(this.convertToCB);
    }


    /**
     * Opens the window.
     */
    public void open() {
        this.mainFrame.setVisible(true);
    }
}
