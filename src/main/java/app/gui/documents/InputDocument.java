package app.gui.documents;

//Java Custom
import app.converter.Converter;

//Java Swing
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class InputDocument extends PlainDocument {
    //Variables:
    private int base;

    public InputDocument(int base) {
        super();
        this.base = base;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if ((str == null)) return;

        for (char c: str.toCharArray())
            if (!(Converter.charToInt(c) < this.base)) return;

        super.insertString(offset, str, attr);
    }
}
