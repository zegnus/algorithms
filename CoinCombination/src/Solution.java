import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We have a set of coin values {3, 9, 8, 4, 5, 7, 10}
 * <p/>
 * We have a target value 15
 * <p/>
 * We want to know all the possible combinations of coins that sums the target value.
 * <p/>
 * Created by ferran on 5/15/14.
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] coins = {3, 9, 8, 4, 5, 7, 10};
        int target = 15;

        sum(coins, target);
    }

    private static void sum(Integer[] pCoins, int pTarget) {
        sum(Arrays.asList(pCoins), pTarget, new ArrayList<Integer>(), 0);
    }

    private static void sum(List<Integer> pCoins, int pTarget, ArrayList<Integer> pCombination, int pSum) {
        if (pSum == pTarget) {
            System.out.println(Arrays.toString(pCombination.toArray()));
            return;
        }

        if (pSum > pTarget) {
            return;
        }

        for (int size = pCoins.size(), i = 0; i < size; i++) {
            ArrayList<Integer> coinsRemaining = new ArrayList<>(pCoins.subList(i + 1, size));

            ArrayList<Integer> newCombination = new ArrayList<>(pCombination);
            newCombination.add(pCoins.get(i));

            int sum = pSum + pCoins.get(i);

            sum(coinsRemaining, pTarget, newCombination, sum);

            // when we return here, we will try with the next element
        }
    }
}
