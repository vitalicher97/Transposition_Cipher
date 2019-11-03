package main;

import encryption.TranspCipher;
import io.*;

public class Main {

    public static void main(String[] args) {

        String inpText, inpKey, flag;

        Read read = new Read();
        Write write = new Write();
        TranspCipher enc = new TranspCipher();

        inpText = read.readString();
        inpKey = read.readString();
        flag = read.readString();
        String resultText = enc.transpCipherEnc(inpText, inpKey, flag);

        System.out.println("Operation result:\n" + resultText);
        write.writeToFile("Result Text.txt", resultText);

    }
}