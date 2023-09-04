package app.mainwindow;

import app.mainwindow.components.BottomPanel;
import app.mainwindow.components.CenterPanel;
import app.mainwindow.components.UpperPanel;

import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public class MainWindow {
    private static final String ICON_PATH = "./assets/icon.png";
    private static final String TITLE = "NSC"; //Number System Convertor
    private static final int HEIGHT = 200;
    private static final int WIDTH = 300;

    private UpperPanel up;
    private CenterPanel cp;
    private BottomPanel bp;

    private JFrame frame;
    private JPanel panel;

    public MainWindow() {
        this.frame = new JFrame();
        this.frame.setIconImage(new ImageIcon(MainWindow.ICON_PATH).getImage());
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(MainWindow.WIDTH, MainWindow.HEIGHT);
        this.frame.setTitle(MainWindow.TITLE);
        this.frame.setResizable(false);

        this.panel = new JPanel(new BorderLayout());

        this.frame.add(this.panel, BorderLayout.CENTER);

        this.up = new UpperPanel(this.panel);
        this.cp = new CenterPanel(this.panel);
        this.bp = new BottomPanel(this.panel, this.up, this.cp);

        this.frame.setVisible(true);
    }
}
