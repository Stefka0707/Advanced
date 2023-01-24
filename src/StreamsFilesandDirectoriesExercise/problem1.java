package StreamsFilesandDirectoriesExercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

public class problem1 {
    public static void main(String[] args) throws IOException {

        try {
            FileInputStream inputStream = new FileInputStream
                    ("C:\\Users\\USER\\IdeaProjects\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
            Scanner scanner = new Scanner(inputStream);
            String str = scanner.nextLine();
            System.out.println(str);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally {
            if (in !=null){
                in.close();
            }
        }
    }
}
