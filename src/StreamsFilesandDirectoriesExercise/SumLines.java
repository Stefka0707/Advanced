package StreamsFilesandDirectoriesExercise;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        //1 взимаме всички редове от файла тхт
        //2 за всеки ред повтаряме действие -> намираме сумата от аски кодовете
   String pathToFile= "C:\\Users\\USER\\IdeaProjects\\Advanced\\src";

   List<String > allFiles = Files.readAllLines(Path.of(pathToFile));
//като светен реад олл лайнес го добавяме като троол ексепщън
        for (String Line:allFiles){
            int sum = 0;
            for (char symbol : Line.toCharArray()){
                sum+=symbol;
            }
            System.out.println(sum);
        }
        //2 начин
//allFiles.forEach(Line -> {
  //              int sum = 0;
    //            for (char symbol : Line.toCharArray()){
      //              sum+=symbol;
        //        }
          //      System.out.println(sum);
            
            
       // });
    }
}
