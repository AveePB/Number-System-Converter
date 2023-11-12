package app.gui.actionlisteners;

//Java Custom
import app.converter.Converter;
import app.gui.documents.InputDocument;

//Java Swing
import javax.swing.JComboBox;
import javax.swing.JTextField;

//Java Abstract Window Toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertFromComboBoxListener implements ActionListener {
    //Variables:
    private JComboBox<String> convertFromCB;
    private JTextField inputTF;

    public ConvertFromComboBoxListener(JComboBox<String> convertFromCB, JTextField inputTF) {
        this.convertFromCB = convertFromCB;
        this.inputTF = inputTF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idx = this.convertFromCB.getSelectedIndex();
        this.inputTF.setDocument(new InputDocument(Converter.NUMBER_BASES_INT[idx]));
    }
}
