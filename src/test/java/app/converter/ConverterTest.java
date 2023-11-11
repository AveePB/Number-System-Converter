package app.converter;

//Java Junit
import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void charToInt() {
        char[] letters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'B', 'c', 'D', 'e', 'F', 'g', 'H', 'i', 'J', 'k', 'L', 'm', 'N',
        'o', 'P', 'q', 'R', 's', 'T', 'U', 'V', 'w', 'X', 'y', 'Z'};

        for (int i=0; i<letters.length; i++) {
            Assert.assertEquals(i, Converter.charToInt(letters[i]));
            System.out.println("Passed " + i + " ✔");
        }
    }

    @Test
    public void intToChar() {
        char[] letters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i=0; i<letters.length; i++) {
            Assert.assertEquals(letters[i], Converter.intToChar(i));
            System.out.println("Passed " + i + " ✔");
        }
    }

    @Test
    public void convertFromDecimal() {
        char[][] answers = {{'7','3','C'}, {'C','E','P'}, {'1','5','H','2'},
                {'1','3','2','H'}, {'7','E','6'}, {'Q','P','8','5'}};
        char[][] numbers = {{'1','2','3','4'}, {'1','1','2','4','5'}, {'8','9','8','9'},
                {'7','9','9','7'}, {'9','0','7','1'}, {'7','9','8','8','4','4'}};
        int[] bases = {13, 30, 19, 19, 35, 31};

        for (int i=0; i<answers.length; i++) {
            Assert.assertArrayEquals(answers[i], Converter.convertFromDecimal(numbers[i], bases[i]));
            System.out.println("Passed " + i + " ✔");
        }
    }

    @Test
    public void convertToDecimal() {
        char[][] answers = {{'1','2','3','4'}, {'1','1','2','4','5'}, {'8','9','8','9'},
            {'7','9','9','7'}, {'9','0','7','1'}, {'7','9','8','8','4','4'}};
        char[][] numbers = {{'7','3','C'}, {'C','E','P'}, {'1','5','H','2'},
                {'1','3','2','H'}, {'7','E','6'}, {'Q','P','8','5'}};
        int[] bases = {13, 30, 19, 19, 35, 31};

        for (int i=0; i<answers.length; i++) {
            Assert.assertArrayEquals(answers[i], Converter.convertToDecimal(numbers[i], bases[i]));
            System.out.println("Passed " + i + " ✔");
        }
    }
}