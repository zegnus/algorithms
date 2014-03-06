import java.util.Arrays;

/**
 * Created by Ferran Garriga on 06/03/14.
 *
 * The problem:
 * A bitonic array is an array the increments up to a certain point, and then decrements.
 * The problem is to find if an element exists in such an array.
 */
public class BitonicSearch {
    public static void main (String[] args) {
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, 19);
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, 9);
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, 3);
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, -10);
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, -3);
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, 3);
        find(new int[]{2, 5, 32, 20, 19, 10, 3}, 5);
    }

    private static void find(int[] pInput, int pValue) {
        int init = 0;
        int end = pInput.length - 1;

        boolean founded = find(pInput, init, end, pValue);

        if (founded) {
            System.out.println(pValue + " exists in " + Arrays.toString(pInput));
        } else {
            System.out.println(pValue + " does NOT exists in " + Arrays.toString(pInput));
        }

    }

    private static boolean find(int[] pInput, int pInit, int pEnd, int pValue) {
        int mid = (pInit + pEnd) / 2;

        if (mid < pInit || mid > pEnd) {
            return false;
        }

        if (pInput[pInit] == pValue || pInput[mid] == pValue || pInput[pEnd] == pValue) {
            return true;
        }

        boolean found = false;

        if (pInput[pInit] > pValue && pInput[mid] < pValue
                || pInput[pInit] < pValue && pInput[mid] > pValue) {
            // the value might be in this section of the array
            found = find(pInput, pInit + 1, mid - 1, pValue);
        }

        if (!found) {
            if (pInput[mid] > pValue && pInput[pEnd] < pValue
                    || pInput[mid] < pValue && pInput[pEnd] > pValue) {
                // the value might be in this section of the array
                found = find(pInput, mid + 1, pEnd - 1, pValue);
            }
        }

        return found;
    }


}
