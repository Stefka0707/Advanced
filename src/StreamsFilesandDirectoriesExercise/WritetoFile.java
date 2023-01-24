package StreamsFilesandDirectoriesExercise;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WritetoFile {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outPutStream = new FileOutputStream("out.txt");

        PrintWriter writer = new PrintWriter(outPutStream);
        int singleByte = inputStream.read();

        Set<Character> punctuations = new HashSet<>();
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('!');
        punctuations.add('?');

        while (singleByte >= 0) {
            char symbol = (char) singleByte;
            if (!punctuations.contains(symbol)) {
                writer.print(symbol);
            }
            singleByte = inputStream.read();
        }
        writer.close();
        inputStream.close();


    }

}
