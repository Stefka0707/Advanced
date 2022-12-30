package StacksandQueuesLab;

import java.util.*;


public class BasicStackOperations2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineInput = scanner.nextLine();
        int[] symbol = Arrays.stream(lineInput.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(e -> stack.push(e));
        int numInStack = symbol[0];
        int numPopFromStack = symbol[1];
        int numCheck = symbol[2];

        for (int i = 1; i <= numPopFromStack; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(numCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }


    }

}


//class Test {
//    // Recursive Method to insert an item x in sorted way
//    static void sortedInsert(Stack<Integer> s, int x)
//    {
//        // Base case: Either stack is empty or newly
//        // inserted item is greater than top (more than all
//        // existing)
//        if (s.isEmpty() || x > s.peek()) {
//            s.push(x);
//            return;
//        }
//
//        // If top is greater, remove the top item and recur
//        int temp = s.pop();
//        sortedInsert(s, x);
//
//        // Put back the top item removed earlier
//        s.push(temp);
//    }

// // Method to sort stack
//    static void sortStack(Stack<Integer> s)
//    {
//        // If stack is not empty
//        if (!s.isEmpty()) {
//            // Remove the top item
//            int x = s.pop();
//
//            // Sort remaining stack
//            sortStack(s);
//
//            // Push the top item back in sorted stack
//            sortedInsert(s, x);
//        }
//    }
