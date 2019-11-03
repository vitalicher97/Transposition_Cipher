package encryption;

import java.util.*;

public class TranspCipher {

    public String transpCipherEnc(String initData, String key){

        String[] keyArr = key.split("|");
        String[] dataArr = initData.split("|");
        int keyLen = keyArr.length; // For matrix first side length
        int dataLen = dataArr.length;
        int textLen = (dataLen / keyLen); // Calculated for matrix second side length
        LinkedHashMap<String, String[]> dataMatrix = new LinkedHashMap<>();
        String encodedText = "";

        // For creating array with enough length
        if(dataLen % keyLen != 0){
            textLen++;
        }

        // Defining matrix size for inputted text
        String[][] textMatrix = new String[keyLen][textLen];

        // Creating matrix that contains text for future encrypting
        int dataArrIndex = 0;
        for(int j = 0; j < textLen; j++){
            for(int i = 0; i < keyLen; i++){
                if(dataArrIndex < dataLen){
                    textMatrix[i][j] = dataArr[dataArrIndex];
                    dataArrIndex++;
                }
            }
        }

        // Map's keys correspond to the inputted keys. Keys corresponds with text matrix rows.
        int letter = 1;
        for(int i = 0; i < keyLen;i++){
            keyArr[i] = keyArr[i] + letter;
            letter++;
            dataMatrix.put(keyArr[i], textMatrix[i]);
        }


        // Keys sorted for letters misplacing. Main feature of transposition cipher encoding method.
        Arrays.sort(keyArr);

        // Assign new letters sequence to the text matrix.
        int temp = 0;
        for(String k : keyArr){
            textMatrix[temp] = dataMatrix.get(k);
            temp++;
        }

        for(int j = 0; j < textLen; j++){
            for(int i = 0; i < keyLen; i++){
                if(textMatrix[i][j] != null){
                    encodedText = encodedText + textMatrix[i][j];
                }
            }
        }


        return encodedText;


    }

}