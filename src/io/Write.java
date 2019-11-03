package io;

import java.io.FileWriter;
import java.io.IOException;

public class Write {

    public void writeToFile(String fileName, String textWrite){

        try{
            FileWriter file = new FileWriter(fileName);
            file.write(textWrite);
            file.close();
        } catch (IOException e){
            System.out.println("io.Write.writeToFile error occurred.");
            e.printStackTrace();
        }

    }

}
