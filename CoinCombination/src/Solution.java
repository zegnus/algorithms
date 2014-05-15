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
        sum(Arrays.asList(pCoins), pTarget, new ArrayList<Integer>());
    }

    private static void sum(List<Integer> pCoins, int pTarget, ArrayList<Integer> pCombination) {
        int sum = 0;
        for (Integer coin : pCombination) {
            sum += coin;
        }

        if (sum == pTarget) {
            System.out.println(Arrays.toString(pCombination.toArray()));
            return;
        }

        if (sum > pTarget) {
            return;
        }

        // we will take all the coins starting from the left and match all the combinations
        // with all the rest of the coins

        int size = pCoins.size();
        for (int i = 0; i < size; i++) {
            // we add the coin to the valid combination
            // we create a new array because the next iteration has to start from the original
            // pCombination
            ArrayList<Integer> newCombination = new ArrayList<Integer>();
            newCombination.addAll(pCombination);
            newCombination.add(pCoins.get(i));

            ArrayList<Integer> coinsRemaining = new ArrayList<Integer>();
            coinsRemaining.addAll(pCoins.subList(i + 1, size));

            sum(coinsRemaining, pTarget, newCombination);

            // when we return here, we will try with the next element
        }
    }
}
