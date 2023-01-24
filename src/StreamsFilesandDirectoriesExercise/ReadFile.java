package StreamsFilesandDirectoriesExercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream inputStrem= new FileInputStream(path);
        int singleByte = inputStrem.read();
        while (singleByte >=0){
            System.out.print(Integer.toBinaryString(singleByte) + " ");

            singleByte=inputStrem.read();
        }
        inputStrem.close();

    }
}
