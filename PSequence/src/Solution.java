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

        int numberOfCombinations = getNumberOfCombinations(N, P);
        System.out.println("combinations of " + P + ", n: " + numberOfCombinations);

        numberOfTotalCombinations = 0;

        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            stack.push(1);
        }

        boolean end = false;

        while (!end) {
            if (stack.size() == N) {
                printStack(stack);
                //numberOfTotalCombinations++;
            }

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

    /**
     * Calculate all possible combinatinos between 1 and pEnd that
     * does not exceed pairs that the multiplication exceeds pEnd
     * @param pEnd
     * @return
     */
    private static int getNumberOfCombinations(int pDigits, int pEnd) {
        int sum = 0;
        int half = pEnd/2;

        for (int i=1; i<=half; i++) {
            sum += pEnd/i;
        }

        int halfEndTotalValidCombinations = pDigits * (pDigits - (pDigits/2));

        System.out.println("halfEndTotalValidCombinations: " + halfEndTotalValidCombinations);

        return sum + pEnd - half;
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
