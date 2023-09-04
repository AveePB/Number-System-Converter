package app.mainwindow.components;

import app.converter.Converter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class BottomPanel {
    private JTextField output;

    public BottomPanel(JPanel panel, UpperPanel up, CenterPanel cp) {
        JPanel sub_panel = new JPanel(new BorderLayout());
        this.initButtons(sub_panel, up, cp);
        this.initSector(sub_panel);

        panel.add(sub_panel, BorderLayout.SOUTH);
    }

    private void initButtons(JPanel panel, UpperPanel up, CenterPanel cp) {
        JPanel btn_panel = new JPanel(new FlowLayout());

        JButton convert_btn = new JButton("Convert");
        convert_btn.addActionListener(new ButtonListener(up, cp, this));
        btn_panel.add(convert_btn);

        JButton reset_btn = new JButton("Reset");
        reset_btn.addActionListener(new ButtonListener(up, cp, this));
        btn_panel.add(reset_btn);

        JButton swap_btn = new JButton("Swap");
        swap_btn.addActionListener(new ButtonListener(up, cp, this));
        btn_panel.add(swap_btn);

        panel.add(btn_panel, BorderLayout.NORTH);
    }

    private void initSector(JPanel panel) {
        JPanel sub_panel = new JPanel(new FlowLayout());

        JLabel header = new JLabel("Result");
        sub_panel.add(header);

        this.output = new JTextField();
        this.output.setColumns(20);
        this.output.setEditable(false);
        sub_panel.add(this.output);

        panel.add(sub_panel, BorderLayout.CENTER);
    }

    private static class ButtonListener implements ActionListener {
        private Converter conv;

        private UpperPanel up;
        private CenterPanel cp;
        private BottomPanel bp;

        public ButtonListener(UpperPanel up, CenterPanel cp, BottomPanel bp) {
            this.conv = new Converter();

            this.up = up;
            this.cp = cp;
            this.bp = bp;
        }

        private void convertAction() {
            long from = this.up.convert_from.getSelectedIndex() + 2;
            long to = this.up.convert_to.getSelectedIndex() + 2;
            String input = this.cp.input.getText().toUpperCase();

            if (this.conv.validate(input, from)) {
                long num = this.conv.convertDiffNumSysToDec(input, from);
                String output = this.conv.convertDecToDiffNumSys(num, to);

                this.bp.output.setText(output);
            }
            else {
                String msg = "Your number isn't valid!";
                JOptionPane.showMessageDialog(null, msg);
            }
        }

        private void resetAction() {
            this.up.convert_from.setSelectedIndex(0);
            this.up.convert_to.setSelectedIndex(0);
            this.cp.input.setText("");
            this.bp.output.setText("");
        }

        private void swapAction() {
            int from_idx = this.up.convert_from.getSelectedIndex();
            int to_idx = this.up.convert_to.getSelectedIndex();

            this.up.convert_from.setSelectedIndex(to_idx);
            this.up.convert_to.setSelectedIndex(from_idx);

            if (this.bp.output.getText().equals("")) {
                this.cp.input.setText("");
            }
            else {
                String input_text = this.cp.input.getText();
                String output_text = this.bp.output.getText();

                this.cp.input.setText(output_text);
                this.bp.output.setText(input_text);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Convert"))
                convertAction();
            else if (e.getActionCommand().equals("Reset"))
                resetAction();
            else
                swapAction();
        }
    }
}
