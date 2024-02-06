package org.javarush.caesercipher;

import java.util.Arrays;
import java.util.List;

public class CaeserCipher {
    private final Alphabet alphabet;

    public CaeserCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public char[] encode(char[] symbols, int key) {
        return cipher(symbols, key);
    }

    public char[] decode(char[] symbols, int key) {
        return cipher(symbols, -key);
    }

    private char[] cipher(char[] chars, int key) {
        char[] symbols = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            symbols[i] = alphabet.method(chars[i], key);
        }
        return symbols;
    }

    public static void main(String[] args) {

        //  encoder: a, b, c, 1, 2
        // 1)  ab!2, key=1 ---> bc!a
        // ....


        // decode: ....
        //***


        List<Character> symbols = Arrays.asList('a', 'b', 'c', '1', '2');
        Alphabet alphabet = new Alphabet(symbols);

        CaeserCipher caeserCipher = new CaeserCipher(alphabet);

        String text = "ab!2";
        int key = 1;
        char[] result = caeserCipher.encode(text.toCharArray(), key);

        System.out.println(new String(result));
    }
}
