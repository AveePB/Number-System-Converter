//Java Custom

import app.converter.Converter;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //MainWindow mw = new MainWindow();
        //mw.open();

        //Need to create tests
        System.out.println(Arrays.toString(Converter.convertFromDecimal(new char[]{'3'}, 3)));
        System.out.println(Arrays.toString(Converter.convertToDecimal(new char[]{'1', '0'}, 3)));
    }
}
