import java.util.Scanner;

/**
 * Created by ferran on 22/04/14.
 */
public class Solution {
    public static final double UPPER_LIMIT = Math.pow(10, 9) + 7;

    private static int mTeamAScore;
    private static int mTeamBScore;
    private static double[][] mCombinations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Team B is the winner
        // Team A is the looser

        if (a > b) {
            mTeamBScore = a;
            mTeamAScore = b;
        } else {
            mTeamBScore = b;
            mTeamAScore = a;
        }

        mCombinations = new double[mTeamAScore + 1][mTeamBScore + 1];
        for (int i = 0; i < mCombinations.length; i++) {
            for (int j = 0; j < mCombinations[0].length; j++) {
                mCombinations[i][j] = -1;
            }
        }

        //double combinations = score(0, 0);
        //System.out.println((int) combinations);

        // Team B only wins if it scores two points more than Team A
        if (mTeamBScore - mTeamAScore < 2) {
            System.out.println("0");
        } else if (mTeamBScore < 25) {
            // Team B only wins if it hits a score >= 25
            System.out.println("0");
        } else if (mTeamBScore - mTeamAScore > 2 && mTeamBScore > 25) {
            System.out.println("0");
        } else {
            double combinations = score(0, 0);

            if (combinations > UPPER_LIMIT) {
                //combinations = combinations % UPPER_LIMIT;
            }

            System.out.println((int) combinations);
        }
    }

    private static double score(int pTeamA, int pTeamB) {

        if (pTeamB == mTeamBScore) {
            if (pTeamA == mTeamAScore) {
                return 1;
            } else {
                return 0;
            }
        }

        double combinationsLeft = 0;
        double combinationsRight = 0;

        if (pTeamA < mTeamAScore && pTeamB < mTeamBScore) {
            // we go left, increment left team only if that is possible and
            // the winner team has not already won
            if (-1 != mCombinations[pTeamA + 1][pTeamB]) {
                combinationsLeft = mCombinations[pTeamA + 1][pTeamB];
                //System.out.println((pTeamA+1) + " " + pTeamB + ": " + mCombinations[pTeamA+1][pTeamB] + ", fast");
            } else {
                combinationsLeft = score(pTeamA + 1, pTeamB);
                mCombinations[pTeamA + 1][pTeamB] = combinationsLeft;
                //System.out.println((pTeamA+1) + " " + pTeamB + ": " + mCombinations[pTeamA+1][pTeamB]);
            }
        }

        if (pTeamB < mTeamBScore) {
            if (-1 != mCombinations[pTeamA][pTeamB + 1]) {
                combinationsRight = mCombinations[pTeamA][pTeamB + 1];
                //System.out.println(pTeamA + " " + (pTeamB+1) + ": " + mCombinations[pTeamA][pTeamB+1] + ", fast");
            } else {
                combinationsRight = score(pTeamA, pTeamB + 1);
                mCombinations[pTeamA][pTeamB + 1] = combinationsRight;
                //System.out.println(pTeamA + " " + (pTeamB+1) + ": " + mCombinations[pTeamA][pTeamB+1]);
            }
        }

        return combinationsLeft + combinationsRight;
    }
}
