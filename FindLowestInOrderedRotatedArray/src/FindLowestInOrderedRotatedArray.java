import java.util.Arrays;

/**
 * Created by ferran on 04/03/14.
 *
 * The problem:
 * We have an ordered but rotated array {6, 7, 8, 9, 1, 2, 3}
 * We need to return 1, as is the lowest value
 *
 * Is a requirement that the array has to have a rotated set of values
 */
public class FindLowestInOrderedRotatedArray {
    public static void main(String[] args) {
        int[] array;

        array = new int[] {6, 8, 10, 12, 2, 4};
        System.out.println("minimum at " + Arrays.toString(array) + " is " + findMinimum(array));

        array = new int[] {31, 32, 1, 2, 4, 5, 6, 7};
        System.out.println("minimum at " + Arrays.toString(array) + " is " + findMinimum(array));

        array = new int[] {6, 7, 8, 9, 10, 11, 12, 1, 2};
        System.out.println("minimum at " + Arrays.toString(array) + " is " + findMinimum(array));

        array = new int[] {6};
        System.out.println("minimum at " + Arrays.toString(array) + " is " + findMinimum(array));

        array = new int[] {6, 5};
        System.out.println("minimum at " + Arrays.toString(array) + " is " + findMinimum(array));

        array = new int[] {8, 9, 10, 1, 2};
        System.out.println("minimum at " + Arrays.toString(array) + " is " + findMinimum(array));
    }

    private static int findMinimum(int[] pInput) {
        int length = pInput.length;
        if(length == 1) {
            return pInput[0];
        }

        int init = 0;
        int end = length - 1;
        int mid = 0;

        while (init != end) {
            mid = (init + end) / 2;

            if (pInput[mid] > pInput[init]) {
                init = mid;
            } else {
                end = mid;
            }
        }

        return pInput[mid + 1];
    }
}
