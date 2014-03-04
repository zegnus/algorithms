import java.util.Arrays;

/**
 * Created by ferran on 03/03/14.
 */
public class BinarySearch {
    public static void main (String[] args) {
        int[] array;
        int value;

        array = new int[] {1, 4, 5, 6, 9, 12, 18, 32};
        value = 4;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1, 4, 5, 6, 9, 12, 18, 32};
        value = 18;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1, 4, 5, 6, 9, 12, 18, 32};
        value = 19;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1, 4, 5, 6, 9, 12, 18, 32};
        value = 2;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1, 4, 5, 6, 9, 12, 18, 32};
        value = 0;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1, 4, 5, 6, 9, 12, 18, 32};
        value = 50;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1};
        value = 50;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));

        array = new int[] {1};
        value = 1;
        System.out.println("find " + value + " in " + Arrays.toString(array) + ": " + find(array, value));
    }

    /**
     * This method considers that the array is ordered.
     * @param pArray The array in which we want to find a specific pValue. This array must be ordered.
     * @param pValue The value that we want to find in pArray
     * @return Whether pValue exists in pArray
     */
    private static boolean find(int[] pArray, int pValue) {
        int init = 0;
        int length = pArray.length;
        int end = length - 1;
        int mid;

        if(length == 0) {
            return false;
        }

        // if there is only one value, we can know straight away
        if(length == 1) {
            return pArray[0] == pValue;
        }

        // if the value that we want to find is less than the lower of the array or greater than the last
        // position of the array, we know straight away
        if(pValue < pArray[0] || pValue > pArray[end]) {
            return false;
        }

        while(init != end) {
            mid = (init + end) / 2;
            if(pArray[mid] == pValue) {
                return true;
            } else if (pArray[mid] > pValue) {
                end = mid - 1;
            } else {
                init = mid + 1;
            }
        }

        return false;
    }
}
