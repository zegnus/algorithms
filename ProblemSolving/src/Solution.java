import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * There are N problems numbered 1..N which you need to complete. You’ve arranged the problems in increasing difficulty order, and the ith problem has estimated difficulty level i. You have also assigned a rating vi to each problem. Problems with similar vi values are similar in nature. On each day, you will choose a subset of the problems and solve them. You’ve decided that each subsequent problem solved on the day should be tougher than the previous problem you solved on that day. Also, to make it less boring, consecutive problems you solve should differ in their vi rating by at least K. What is the least number of days in which you can solve all problems?
 * <p/>
 * Input Format
 * <p/>
 * The first line contains the number of test cases T. T test cases follow. Each case contains an integer N and K on the first line, followed by integers v1,…,vn on the second line.
 * <p/>
 * Output Format
 * <p/>
 * Output T lines, one for each test case, containing the minimum number of days in which all problems can be solved.
 * <p/>
 * Constraints
 * <p/>
 * 1 <= T <= 100
 * 1 <= N <= 300
 * 1 <= vi <= 1000
 * 1 <= K <= 1000
 * <p/>
 * Sample Input
 * <p/>
 * 2
 * 3 2
 * 5 4 7
 * 5 1
 * 5 3 4 5 6
 * <p/>
 * Sample Output
 * <p/>
 * 2
 * 1
 * <p/>
 * Explanation
 * <p/>
 * For the first example, you can solve the problems with rating 5 and 7 on the first day and the problem with rating 4 on the next day. Note that the problems with rating 5 and 4 cannot be completed consecutively because the ratings should differ by at least K (which is 2). Also, the problems cannot be completed in order 5,7,4 in one day because the problems solved on a day should be in increasing difficulty level.
 * <p/>
 * For the second example, all problems can be solved on the same day.
 * <p/>
 * Created by ferran on 05/05/14.
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ProblemSolving/files/test1.txt"));
        //Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt();

        for (int i = 0; i < nTests; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int[] problem = new int[N];

            for (int j = 0; j < N; j++) {
                problem[j] = scanner.nextInt();
            }

            int minDays = Integer.MAX_VALUE;

            for (int startPoint = 0; startPoint < N; startPoint++) {
                int[] component = new int[N];
                int nComponent = 1;

                // from startPoint to N
                for (int j = startPoint; j < N - 1; j++) {

                    if (component[j] == 0) {
                        component[j] = nComponent;
                        int pivot = j;

                        for (int k = pivot+1; k < N; k++) {
                            if (component[k] == 0 && Math.abs(problem[pivot] - problem[k]) >= K) {
                                component[k] = nComponent;
                                pivot = k;
                            }
                        }

                        nComponent++;
                    }
                }

                // from 0 to N
                for (int j = 0; j < N - 1; j++) {
                    if (component[j] == 0) {
                        component[j] = nComponent;
                        int pivot = j;

                        for (int k = pivot+1; k < N; k++) {
                            if (component[k] == 0 && Math.abs(problem[pivot] - problem[k]) >= K) {
                                component[k] = nComponent;
                                pivot = k;
                            }
                        }

                        nComponent++;
                    }
                }

                System.out.println(nComponent - 1);

                if (nComponent < minDays) {
                    minDays = nComponent;
                }
            }

            System.out.println(minDays - 1);
        }
    }
}
