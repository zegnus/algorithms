import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        System.out.println(Arrays.toString(actual));

    }

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        if (myArray.length == 0) {
            return alicesArray;
        }

        if (alicesArray.length == 0) {
            return myArray;
        }

        // combine the sorted arrays into one large sorted array
        int[] result = new int[myArray.length + alicesArray.length];
        int indexMyArray = 0;
        int indexAlicesArray = 0;

        for (int i = 0; i < result.length; i++) {

            if (indexMyArray >= myArray.length) {
                result[i] = alicesArray[indexAlicesArray];
                indexAlicesArray++;
                continue;
            }

            if (indexAlicesArray >= alicesArray.length) {
                result[i] = myArray[indexMyArray];
                indexMyArray++;
                continue;
            }

            if (myArray[indexMyArray] < alicesArray[indexAlicesArray]) {
                result[i] = myArray[indexMyArray];
                indexMyArray++;
            } else {
                result[i] = alicesArray[indexAlicesArray];
                indexAlicesArray++;
            }
        }

        return result;
    }
}
