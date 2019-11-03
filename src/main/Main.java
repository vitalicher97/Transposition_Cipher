package main;

import encryption.TranspCipher;
import io.*;

public class Main {

    public static void main(String[] args) {

        String inpText, inpKey;

        Read read = new Read();
        Write write = new Write();
        TranspCipher enc = new TranspCipher();

        inpText = read.readString();
        inpKey = read.readString();
        String encodedText = enc.transpCipherEnc(inpText, inpKey);

        System.out.println(encodedText);
        write.writeToFile("Encoded Text.txt", encodedText);

    }
}