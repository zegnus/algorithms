import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ferran on 4/24/14.
 */
public class Solution {
    private static int numberOfTotalCombinations;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int P = scanner.nextInt();

        numberOfTotalCombinations = 0;

        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            stack.push(1);
        }

        boolean end = false;

        while (!end) {
            //if (stack.size() == N) {
                printStack(stack);
                //numberOfTotalCombinations++;
            //}

            int nextElement = stack.poll() + 1;

            // let's check if we can add a next number
            if (!stack.isEmpty() && stack.peek() * nextElement <= P) {
                // yes, we can stack the next number
                stack.push(nextElement);

                // as there is a new number we fill the rest of the stack with 1s
                while (stack.size() < N) {
                    stack.push(1);
                }
            } else if (stack.isEmpty() && nextElement <= P){
                stack.push(nextElement);
                while (stack.size() < N) {
                    stack.push(1);
                }
            }

            if (stack.isEmpty()) {
                end = true;
            }
        }

        System.out.println((int)(numberOfTotalCombinations % (Math.pow(10, 9) + 7)));
    }

    private static void printStack(LinkedList<Integer> pStack) {
        numberOfTotalCombinations++;

        int size = pStack.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(pStack.get(i) + " ");
        }

        System.out.println();
    }
}
