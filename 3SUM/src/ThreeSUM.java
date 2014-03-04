/**
 * Created by ferran on 04/03/14.
 *
 * The problem:
 *
 * Considering that we have an array or ordered integers,
 * we need to find three values that sums 0.
 *
 */
public class ThreeSUM {
    public static void main(String[] args) {
        findThreeValuesSumZero(new int[]{-25, -10, -2, 3, 5, 7, 20});
    }

    /**
     * In order to solve this problem, we will have three indexes.
     *
     * The first one will be the most left element in the array and will be the reference
     *
     * The second one will start as a second right position from the first one and will
     * be going right as long as we need to add a greater value.
     *
     * The third one will start at the end and will go towards the second one as long
     * as we need to add a lower value.
     *
     * When the second index and the third index are in the same position,
     * we finish that sequence and we increment by one the first index. And we start again
     *
     * @param pInput
     */
    private static void findThreeValuesSumZero(int[] pInput) {
        int length = pInput.length;
        int a, b, c;

        // we go up to N - 3 because
        // c will be at N - 1
        // b will be at N - 2
        for (a = 0; a < length - 2; a++) {

            b = a + 1;
            c = length - 1;

            if (pInput[a] + pInput[b] > 0) {
                // if we end up here, there is no way to make 0 so
                // we will stop the program
                break;
            }

            while (b != c) {
                int sum = pInput[a] + pInput[b] + pInput[c];

                if (sum == 0) {
                    // bingo, we have a combination
                    System.out.println(pInput[a] + " " + pInput[b] + " " + pInput[c]);
                    b = c;
                } else if (sum < 0) {
                    // the sum is negative, this means that we need to sum a greater number
                    b++;
                } else {
                    // the sum is positive, this means that we need to sum a lower number
                    c--;
                }
            }
        }
    }
}
