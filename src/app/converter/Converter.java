package app.converter;

import java.util.HashMap;

public class Converter {
    private static final long INF = Long.MAX_VALUE;

    private HashMap<Character, Long> char_to_long;
    private HashMap<Long, Character> long_to_char;

    public Converter() {
        this.initHashMaps();
    }

    private void initHashMaps() {
        this.char_to_long = new HashMap<>();
        this.long_to_char = new HashMap<>();

        for (int i=0; i<10; i++) {
            char c = (char)('0' + i);

            this.char_to_long.put(c, (long) i);
            this.long_to_char.put((long) i, c);
        }

        for (int i=0; i<26; i++) {
            char c = (char)('A' + i);
            long num = i + 10;

            this.char_to_long.put(c, num);
            this.long_to_char.put(num, c);
        }
    }

    public String convertDecToDiffNumSys(long num, long sys) {
        StringBuilder converted_num = new StringBuilder();

        while (num != 0) {
            converted_num.append(this.long_to_char.get(num % sys));
            num /= sys;
        }

        if (converted_num.isEmpty()) converted_num.append('0');
        return converted_num.reverse().toString();
    }

    public long convertDiffNumSysToDec(String num, long sys) {
        long dec_num = 0;

        for (char c: num.toCharArray())
            dec_num = dec_num * sys + this.char_to_long.get(c);

        return dec_num;
    }

    public boolean validate(String input, long sys) {
        for (char c: input.toCharArray()) {
            long num = this.char_to_long.getOrDefault(c, Converter.INF);
            if (!(num < sys)) return false;
        }
        return true;
    }
}
