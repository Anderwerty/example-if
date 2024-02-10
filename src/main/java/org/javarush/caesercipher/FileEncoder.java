package org.javarush.caesercipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileEncoder {
    // if small file: read from file all text ---> encode --> write to new file

    private final CaeserCipher caeserCipher;
    private final FileService fileService;
    private final int bufferSize;

    public FileEncoder(CaeserCipher caeserCipher, FileService fileService, int bufferSize) {
        this.caeserCipher = caeserCipher;
        this.fileService = fileService;
        this.bufferSize = bufferSize;
    }

    public void encode(String sourceFilename, int key) {
        String targetFilename = fileService.createTargetFilename(sourceFilename, Type.ENCODE );

        //......
        try (FileWriter writer = new FileWriter(new File(targetFilename));
             FileReader reader = new FileReader(new File(targetFilename))) {
            char[] buffer = new char[bufferSize];

            int numberOfSymbols;

            while ((numberOfSymbols = reader.read(buffer)) != -1) {
                writer.write(caeserCipher.encode(buffer, key), 0, numberOfSymbols);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e); // use your custom unchecked exception
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void decode(String sourceFilename, int key) {

    }


    public static void main(String[] args) {
        List<Character> symbols = Arrays.asList('a', 'b', 'c', '1', '2');
        Alphabet alphabet = new Alphabet(symbols);

        CaeserCipher caeserCipher = new CaeserCipher(alphabet);
        FileService fileService = new FileService();
        FileEncoder fileEncoder = new FileEncoder(caeserCipher, fileService, 128);
        fileEncoder.encode("c:/...", 0);

        FileEncoder fileEncoder2 = new FileEncoder(caeserCipher, fileService, 1024);



        // key 0 --->
    }
}
