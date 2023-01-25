package StreamsFilesandDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordCount {
    public static void main(String[] args) throws IOException {

        //words.txt -> думи който трябва да търсим
        String pathWords = "input.txt";

        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        Map<String, Integer> countWords = new HashMap<>();
        for (String line : allLinesWithWords) {
            String[] wordOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordOnCurrentRow).forEach(word -> {
                countWords.put(word, 0);
            });

        }
        //преброяваме колко пъти се срещат думите
        //  countWords тук съхраняваме думите, които ще броим.

        String pathText = "C:\\Users\\USER\\Desktop\\PBJava 7.2022\\JavaAdvanced\\Advanced2023\\Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));
        for (String lines : allLinesWithText) {
           // KAK ДА СЕ ОТЪРВЕМ ТО ТОЧКИТЕ И ЗАПЕТАЙТЕ В ДОКУМЕНТА
          lines=  lines.replaceAll("[\\,\\.\\?\\!\\:]","");
            String[] wordsOnRow = lines.split("\\s+");
            for (String word : wordsOnRow) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }
        //сортираме записите по броя на срещанията
        // ключ е думата а велю е броя на срещаноята
        // правим сортиране велю по десендинг ордер

        PrintWriter writer = new PrintWriter("result.txt");
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

         //  sorted (число) работи с число на базата на compareTo
        //число е 0 -> не разменя местата на записите
        // число е 1 -> разменя местата на записите
        //число е -1 -> не разменя местата на записите

        //compareTo -> връща цяло число
        // 0 -> първото == второто
        // 1 -> първото > втрото
        // -1 -> първото < второто

        //

    }

}



