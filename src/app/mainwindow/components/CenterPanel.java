package app.mainwindow.components;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class CenterPanel {
    protected JTextField input;

    public CenterPanel(JPanel panel) {
        JPanel sub_panel = new JPanel(new FlowLayout());
        initSector(sub_panel);
        panel.add(sub_panel, BorderLayout.CENTER);
    }

    private void initSector(JPanel panel) {
        JLabel header = new JLabel("Enter Number");
        panel.add(header);

        this.input = new JTextField();
        this.input.setColumns(20);
        panel.add(this.input);
    }
}
