import java.util.Scanner;

/**
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail and notices that two consecutive stones have a difference of either a or b. Legend has it that there is a treasure trove at the end of the trail and if Manasa can guess the value of the last stone, the treasure would be hers. Given that the number on the first stone was 0, find all the possible values for the number on the last stone.
 * <p/>
 * Note : The numbers on the stones are in increasing order
 * <p/>
 * Input Format
 * The first line contains an integer T i.e. the number of Test cases. T testcases follow.
 * Each testcase has 3 lines. The first line contains n ( the number of steps ) The second line contains a. The third line contains b.
 * <p/>
 * Output Format
 * Space separated list of numbers which are the possible values of the last stone in increasing order.
 * <p/>
 * Constraints
 * 1 ≤ T ≤ 10
 * 1 ≤ n, a, b ≤ 103
 * <p/>
 * Sample Input 00
 * <p/>
 * 2
 * 3
 * 1
 * 2
 * 4
 * 10
 * 100
 * Sample Output 00
 * <p/>
 * 2 3 4
 * 30 120 210 300
 * Explanation
 * <p/>
 * All possible series for first test cases are given below.
 * <p/>
 * 0,1,2
 * 0,1,3
 * 0,2,3
 * 0,2,4
 * Hence the answer 2 3 4.
 * <p/>
 * Series with different number of final step for second test cases are
 * <p/>
 * 0, 10, 20, 30
 * 0, 10, 20, 120
 * 0, 10, 110, 210
 * 0, 100, 200, 300
 * hence the answer 30 120 210 300
 * <p/>
 * Created by ferran on 5/6/14.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt();

        for (int i = 0; i < nTests; i++) {
            int steps = scanner.nextInt() - 1;
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // A has to be less than B
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            // first case a a a a a a
            // middle case a a a a b b
            // last case b b b b b b

            int end = steps;

            for (int step = 0; step < steps + 1; step++) {
                int sum = 0;

                // sum of a's
                for (int j = 0; j < end; j++) {
                    sum += a;
                }

                // sum of b's
                for (int k = end; k < steps; k++) {
                    sum += b;
                }

                System.out.print(sum + " ");

                end--;
            }

            System.out.println();
        }
    }
}
