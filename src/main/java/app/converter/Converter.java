package app.converter;

//Java Language
import java.lang.Integer;
import java.lang.StringBuilder;

/**
 * The class is used as the container
 * for the static functions. The Functions
 * allow to convert number between many
 * numeral systems (2-36).
 */
public class Converter {
    /**
     * Converts the given character to its integer value.
     * @param c the character c (0-9, a-z, A-Z).
     * @return the integer value.
     */
    public static int charToInt(char c) {
        if ('A' <= c && c <= 'Z') return c - 'A' + 10;
        if ('a' <= c && c <= 'z') return c - 'a' + 10;
        if ('0' <= c && c <= '9') return c - '0';

        return Integer.MAX_VALUE;
    }

    /**
     * Converts the given integer to its character value.
     * @param i the number (0-35).
     * @return the character value.
     */
    public static char intToChar(int i) {
        if (0 <= i && i <= 9) return (char) ('0' + i);
        if (10 <= i && i <= 35) return (char) ('A' + i - 10);

        return ' ';
    }

    /**
     * Converts the decimal number to one of the number systems.
     * @param numChars the decimal number.
     * @param sys the numeral system base (2-36).
     * @return the converted number.
     */
    public static char[] convertFromDecimal(char[] numChars, int sys) {
        //Converts variables from characters to the long value.
        long num = 0;
        for (char c : numChars)
            num = num * 10 + charToInt(c);

        //Converts a number to the wanted numeral system.
        StringBuilder convertedNumber = new StringBuilder();
        while (num != 0) {
            int charIntVal = (int) (num % (long) sys);
            convertedNumber.append(Converter.intToChar(charIntVal));
            num /= sys;
        }

        return convertedNumber.reverse().toString().toCharArray();
    }

    /**
     * Converts the number  to the decimal system.
     * @param numChars the number of the base sys.
     * @param sys the numeral system base (2-36).
     * @return the decimal number.
     */
    public static char[] convertToDecimal(char[] numChars, int sys) {
        //Converts a number to the decimal system.
        long num = 0;
        for (char c: numChars)
            num = num * sys + Converter.charToInt(c);

        //Converts the decimal number to the char array.
        StringBuilder decimalNumber = new StringBuilder();
        while (num != 0) {
            decimalNumber.append(num % 10);
            num /=10;
        }

        return decimalNumber.reverse().toString().toCharArray();
    }
}
