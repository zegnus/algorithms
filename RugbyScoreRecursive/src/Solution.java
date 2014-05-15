import java.util.ArrayList;
import java.util.Arrays;

/**
 * We have an infinite number of coins with values {1, 2, 5, 10} and a target 15
 *
 * We want to know all the possible combinations of coins that sums up to the target
 * considering that we can use a coin as many times as we want.
 *
 * For example
 * {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 * {1, 2, 2, 5, 5}
 * {5, 5, 5}
 *
 * Created by ferran on 5/15/14.
 */
public class Solution {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 0;
        int target = 4;

        sum(coins, sum, new ArrayList<Integer>(), target);
    }

    private static void sum(int[] pCoins, int pSum, ArrayList<Integer> pList, int pTarget) {

        if (pSum >= pTarget) {
            if (pSum == pTarget) {
                System.out.println(Arrays.toString(pList.toArray()));
            }
            return;
        }

        for (int pCoin : pCoins) {
            int sum = pSum + pCoin;

            ArrayList<Integer> newList = new ArrayList(pList);
            newList.add(pCoin);

            sum(pCoins, sum, newList, pTarget);
        }
    }
}
