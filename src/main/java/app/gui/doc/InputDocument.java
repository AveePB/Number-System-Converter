package app.gui.doc;

//Java Custom
import app.converter.Converter;

//Java Swing
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class InputDocument extends PlainDocument {
    //Constants:
    public static int[] NUMBER_BASES = {2, 3, 4, 5, 6, 7, 8, 9, 10,
    11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
    27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

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
