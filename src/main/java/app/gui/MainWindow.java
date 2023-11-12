package app.gui;

//Java Swing
import javax.swing.*;

//Java Abstract Window Toolkit
import java.awt.*;

//Java Language
import java.lang.String;

public class MainWindow {
    //Constants:
    private static final String[] NUMBER_BASES = {"Base-2", "Base-3", "Base-4", "Base-5", "Base-6", "Base-7",
    "Base-8", "Base-9", "Base-10", "Base-11", "Base-12", "Base-13", "Base-14", "Base-15", "Base-16", "Base-17",
    "Base-18", "Base-19", "Base-20", "Base-21", "Base-22", "Base-23", "Base-24", "Base-25", "Base-26", "Base-27",
    "Base-28", "Base-29", "Base-30", "Base-31", "Base-32", "Base-33", "Base-34", "Base-35", "Base-36",};
    public static final int WINDOW_WIDTH = 370, WINDOW_HEIGHT = 250;
    public static final String WINDOW_ICON_PATH = "./assets/img/icon.png";

    //GUI components:
    private JButton convertBtn;
    private JComboBox<String> convertFromCB, convertToCB;
    private JFrame mainFrame;
    private JTextField inputJTF, outputJTF;

    /**
     * Constructs a main window object.
     */
    public MainWindow() {
        initializeMainFrame();
        initializeComboBoxes();
        initializeTextFields();
        initializeButton();
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

    /**
     * It initializes the combo boxes section. It's
     * required to initialize main frame first!
     */
    private void initializeComboBoxes() {
        Font titleFont = new Font("", Font.PLAIN, 17);
        Font CBFont = new Font("", Font.BOLD, 13);

        //Convert From Combo Box
        JLabel convertFromLabel = new JLabel("Convert From");
        convertFromLabel.setBounds(30, 10, 100, 30);
        convertFromLabel.setFont(titleFont);

        this.convertFromCB = new JComboBox<>(MainWindow.NUMBER_BASES);
        this.convertFromCB.setBounds(30, 40, 120, 30);
        this.convertFromCB.setFont(CBFont);


        //Convert To Combo Box
        JLabel convertToLabel = new JLabel("Convert To");
        convertToLabel.setBounds(200, 10, 100, 30);
        convertToLabel.setFont(titleFont);

        this.convertToCB = new JComboBox<>(MainWindow.NUMBER_BASES);
        this.convertToCB.setBounds(200, 40, 120, 30);
        this.convertToCB.setFont(CBFont);


        //Adds GUI components to the frame.
        this.mainFrame.add(convertFromLabel);
        this.mainFrame.add(this.convertFromCB);
        this.mainFrame.add(convertToLabel);
        this.mainFrame.add(this.convertToCB);
    }

    /**
     * It initializes the text fields section. It's
     * required to initialize main frame first!
     */
    private void initializeTextFields() {
        Font titleFont = new Font("", Font.PLAIN, 15);
        Font TFFont = new Font("", Font.PLAIN, 25);

        //Input Text Field
        JLabel inputLabel = new JLabel("Input");
        inputLabel.setBounds(30, 70, 130, 40);
        inputLabel.setFont(titleFont);

        this.inputJTF = new JTextField();
        this.inputJTF.setBounds(30, 100, 130, 40);
        this.inputJTF.setFont(TFFont);
        this.inputJTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //Output Text Field
        JLabel outputLabel = new JLabel("Output");
        outputLabel.setBounds(200, 70, 130, 40);
        outputLabel.setFont(titleFont);

        this.outputJTF = new JTextField();
        this.outputJTF.setBounds(200, 100, 130, 40);
        this.outputJTF.setFont(TFFont);
        this.outputJTF.setEditable(false);
        this.outputJTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        //Adds GUI components to the frame.
        this.mainFrame.add(inputLabel);
        this.mainFrame.add(this.inputJTF);
        this.mainFrame.add(outputLabel);
        this.mainFrame.add(this.outputJTF);
    }

    /**
     * It initializes the button section. It's
     * required to initialize main frame first!
     */
    private void initializeButton() {
        Font btnFont = new Font("", Font.PLAIN, 16);

        //Convert Button
        this.convertBtn = new JButton("Convert");
        this.convertBtn.setBounds(120, 155, 120, 30);
        this.convertBtn.setFont(btnFont);

        //Adds GUI components to the frame.
        this.mainFrame.add(this.convertBtn);
    }

    /**
     * Opens the window.
     */
    public void open() {
        this.mainFrame.setVisible(true);
    }
}
