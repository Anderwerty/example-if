package org.javarush.caesercipher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alphabet {
    private final List<Character> symbols; //

    public Alphabet(List<Character> symbols) {
        this.symbols = Collections.unmodifiableList(symbols);
    }

    public Character method(Character original, int shift) {
        if (!symbols.contains(original)) {
            return original;
        }

        return null; // TODO: implement here
    }


    // this main method just for testing
    public static void main(String[] args) {
        // a,b,c,1,2
        List<Character> symbols = Arrays.asList('a','b','c', '1','2');
        Alphabet alphabet = new Alphabet(symbols);
        Character result = alphabet.method('a', 1);

        System.out.println(result);

        // 1. a,key=1 ---> b
        // 2. r,key=1 ---> r
        // 3. 1,key=2 ---> a
        // 4. a, key=9 ---> 2
    }
}
