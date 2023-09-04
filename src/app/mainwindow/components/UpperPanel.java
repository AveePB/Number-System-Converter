package app.mainwindow.components;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class UpperPanel {
    private static final String[] NUMERAL_SYSTEMS = {"2", "3", "4", "5", "6", "7", "8",
    "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
    "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"};

    protected JComboBox convert_from, convert_to;

    public UpperPanel(JPanel panel) {
        JPanel sub_panel = new JPanel();
        this.initSectors(sub_panel);
        panel.add(sub_panel, BorderLayout.NORTH);
    }

    private void initSectors(JPanel panel) {
        //CONVERT FROM (WEST SECTOR)
        JPanel west_panel = new JPanel(new FlowLayout());

        JLabel west_header = new JLabel("From");
        west_panel.add(west_header);

        this.convert_from = new JComboBox(UpperPanel.NUMERAL_SYSTEMS);
        west_panel.add(this.convert_from);

        panel.add(west_panel, BorderLayout.WEST);

        //CONVERT TO (EAST SECTOR)
        JPanel east_panel = new JPanel();
        east_panel.setLayout(new FlowLayout());

        JLabel east_header = new JLabel("To");
        east_panel.add(east_header);

        this.convert_to = new JComboBox(UpperPanel.NUMERAL_SYSTEMS);
        east_panel.add(this.convert_to);

        panel.add(east_panel, BorderLayout.EAST);
    }
}
