package app.converter.tests;

import app.converter.Converter;

import java.util.Random;

public class Tests {
    private static final String passed = "Passed";
    private static final String failed = "Failed";

    public static void run(int n_tests) {
        Converter conv = new Converter();
        Random rand = new Random();

        for (int i=1; i<=n_tests; i++)
            generateTest(conv, rand, i);
    }


    private static void generateTest(Converter conv, Random rand, int test_id) {
        long dec_num = rand.nextInt(0, Integer.MAX_VALUE);
        long sys = rand.nextInt(2, 36);

        String converted_num = conv.convertDecToDiffNumSys(dec_num, sys);
        long converted_dec_num = conv.convertDiffNumSysToDec(converted_num, sys);

        System.out.print("TEST " + String.valueOf(test_id) + ": ");

        if (converted_dec_num == dec_num)
            System.out.println(Tests.passed);
        else
            System.out.println(Tests.failed);
    }
}
