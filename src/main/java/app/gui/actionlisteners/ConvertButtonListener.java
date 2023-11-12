package app.gui.actionlisteners;

//Java Custom
import app.converter.Converter;

//Java Swing
import javax.swing.JComboBox;
import javax.swing.JTextField;

//Java Abstract Window Toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertButtonListener implements ActionListener {
    //Variables:
    private JComboBox<String> convertFromCB, convertToCB;
    private JTextField inputTF, outputTF;

    public ConvertButtonListener(JComboBox<String> convertFromCB, JComboBox<String> convertToCB, JTextField inputTF, JTextField outputTF) {
        this.convertFromCB = convertFromCB;
        this.convertToCB = convertToCB;
        this.inputTF = inputTF;
        this.outputTF = outputTF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int baseFrom = Converter.NUMBER_BASES_INT[this.convertFromCB.getSelectedIndex()];
        int baseTo = Converter.NUMBER_BASES_INT[this.convertToCB.getSelectedIndex()];

        char[] decimalNumber = Converter.convertToDecimal(this.inputTF.getText().toCharArray(), baseFrom);
        this.outputTF.setText(new String(Converter.convertFromDecimal(decimalNumber, baseTo)));
    }
}
