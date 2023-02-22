package IteratorsAndComparators;

import java.util.Arrays;

public class MainDemo {
    public static void main(String[] args) {
        System.out.println("Hello java");
        display("Some");
        display("Massage");
        displayMultiple("a","b","c");
        displayArray(new  String[]{"b","b","c"});

    }
    private  static  void display(String msg){
        System.out.println(msg);
    }
    private  static  void  displayMultiple(String...massages){
       String element = massages[0];
       String [] arr = massages;
        Arrays.stream(massages);
        //може и да се обходи
        for (String massage:massages) {
            System.out.println(massage);

        }

    }
private  static  void displayArray(String[]arr){

}

}
