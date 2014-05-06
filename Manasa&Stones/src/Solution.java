import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ferran on 5/6/14.
 */
public class Solution {
    private static List<Integer> mAnswer;
    private static int mSteps;
    private static int mA, mB;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt();

        for (int i = 0; i < nTests; i++) {
            mSteps = scanner.nextInt();
            mA = scanner.nextInt();
            mB = scanner.nextInt();

            mAnswer = new ArrayList<Integer>((int) Math.pow(2, 4));
            add(1, 0);
            Collections.sort(mAnswer);
            for (Integer value : mAnswer) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    private static void add(int pSize, int pValue) {
        if (pSize < mSteps) {
            add(pSize+1, pValue+mA);
            add(pSize+1, pValue+mB);
        } else {
            if (!mAnswer.contains(pValue)) {
                mAnswer.add(pValue);
            }
        }
    }
}
