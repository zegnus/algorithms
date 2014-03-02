import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Created by Ferran Garriga on 02/03/14.
 * </p>
 * <p/>
 * <p>
 * Description of the problem:
 * We have an array with integer {1, 4, 6}
 * The objective is to find all the possible combinations and repetitions
 * of the values in the array that sums up to a specific value.
 * </p>
 * <p/>
 * <p>
 * For example:
 * {1,2,3} - 4
 * </p>
 * <p/>
 * <p>
 * Result:
 * {1,1,1,1}
 * {1,1,2}
 * {1,2,1}
 * {1,3}
 * {2,2}
 * {2,1,1}
 * </p>
 */
public final class RugbyScore {
    public static void main(final String[] args) {
        System.out.println("test");
        compute(new int[] {1, 2, 3, 4} , 8);
    }

    /**
     * <p>
     * The overall idea of this solution is the following:
     * </p>
     * <p>
     * Note: for clarity, I will indicate that the stack has the values
     * of the array, but in the implementation we will add the indexes only.
     * </p>
     * <p>
     * We are going to stack the first position of the array, for example
     * {1, 1, 1, 1, 1 ...} until the sum is == or > than pObjective.
     * As so for pObjective 4, we will have {1 1 1 1}.
     * </p>
     * <p>
     * When that happens, in the best scenario, we should unstack the first
     * element, unstack the first element again and we get the index. We will
     * end up with {1 1} and index of 1 that is 0. We increment the index and
     * we add it into the stack {1 1 2}.
     * </p>
     * <p>
     * We need to consider two cases:
     * <ul>
     * <li>We cannot unstack anything when the stack is empty</li>
     * <li>We cannot add the next index when the index is at the end of the array</li>
     * </ul>
     * </p>
     *
     * @param pValue The array of values that we can use in order to sum pObjective
     * @param pObjective The value that we need to sum with any combinatino of pValue
     */
    private static void compute(final int[] pValue, final int pObjective) {
        final LinkedList<Integer> stack = new LinkedList<Integer>();

        int pValueLength = pValue.length - 1;

        stack.addFirst(0);
        int sum = 0;
        sum += pValue[0];

        int index;
        while (!stack.isEmpty()) {
            if (sum < pObjective) {
                stack.addFirst(0);
                sum += pValue[0];
            } else {
                if (sum == pObjective) {
                    printStack(pValue, stack);
                }

                // The idea of the following code follows:
                // we remove the first item in the stack
                // we remove the first item in the stack again
                // we increment the index
                // we add the new value on top of the stack
                //
                // This approach work in the general case but there are
                // few cases where it does not work
                //
                // - If the stack is empty, we cannot remove anything
                // - We can only increment the index if we are not
                // already in the last position of the index. In this scenario
                // we should remove another item, increment the index and add it
                // at the top of the stack. But we have to check again if the
                // stack is not empty and that we can add the next element. We
                // need to do that in a loop until all the conditions are fine.
                // This is why of the loop

                // we remove the top of the stack
                index = stack.pollFirst();
                sum -= pValue[index];

                boolean loop = true;

                while (loop) {
                    if (!stack.isEmpty()) {
                        // we remove the top of the stack
                        index = stack.pollFirst();
                        sum -= pValue[index];

                        if (index < pValueLength) {
                            index++;
                            stack.addFirst(index);
                            sum += pValue[index];

                            // end loop
                            loop = false;
                        } else {
                            // loop
                            loop = true;
                        }
                    }
                }
            }
        }
    }

    private static void printStack(final int[] pValue, LinkedList<Integer> pStack) {
        // we will print the stack in inverse order for clarity
        if (pStack != null) {
            final List<Integer> clone = (List<Integer>) pStack.clone();
            Collections.reverse(clone);
            for (final int index : clone) {
                System.out.print(pValue[index] + " ");
            }
            System.out.println("");
        }
    }
}
