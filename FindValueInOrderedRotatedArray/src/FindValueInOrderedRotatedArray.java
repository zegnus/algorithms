import java.util.Arrays;

/**
 * Created by ferran on 08/03/14.
 *
 * The problem:
 *
 * We need to find out if a value exists in an ordered and rotated array
 * {9, 10, 11, 12, 1, 2, 3, 4}
 */
public class FindValueInOrderedRotatedArray {
    public static void main(String[] args) {
        int[] input;
        int value;

        input = new int[]{9, 10, 1, 2, 3, 4, 5, 6, 7, 8};
        value = 11;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = 10;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = 2;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        input = new int[]{9, 10, 1, 2, 3, 4, 5, 7, 8};
        value = 6;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = 7;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        input = new int[]{3, 4, 6, 9, 11, 32, -1, 1};
        value = 6;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = 32;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = -1;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = 4;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));

        value = 0;
        System.out.println(value + " in " + Arrays.toString(input) + " exists: " + find(input, value));
    }

    private static boolean find(int[] pInput, int pValue) {
        int init = 0;
        int end = pInput.length - 1;

        while (init < end) {
            int mid = (init + end) / 2;

            if (pInput[init] == pValue
                    || pInput[mid] == pValue
                    || pInput[end] == pValue) {
                return true;
            }

            // is the value in the left side?
            // {1, 2, 3, 4} value 2 is inside, value 5 is not -> case A
            // {9, 10, 1, 2} value 8 is not, value 3 is not, value 11 is inside, value 1 is inside -> case B

            boolean caseA = pInput[init] < pInput[mid]
                    && pInput[init] < pValue
                    && pInput[mid] > pValue;

            boolean caseB = pInput[init] > pInput[mid]
                    && (pInput[init] < pValue || pInput[mid] > pValue);

            if (caseA || caseB) {
                // the value should be in the left side
                init++;
                end = mid - 1;
            } else {
                // the value should be in the right side
                end--;
                init = mid + 1;
            }
        }

        return false;
    }
}
