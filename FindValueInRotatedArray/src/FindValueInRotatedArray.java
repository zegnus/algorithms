public class FindValueInRotatedArray {

    public static void main(String[] args) {

        boolean found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 8);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 9);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 1);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 2);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 3);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 4);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 5);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 1, 2, 3, 4, 5}, 6);
        System.out.println(!found);

        found = findValue(new int[]{8, 9, 1, 2, 3}, 10);
        System.out.println(!found);

        found = findValue(new int[]{9, 1}, 0);
        System.out.println(!found);

        found = findValue(new int[]{8, 9, 1}, 10);
        System.out.println(!found);

        found = findValue(new int[]{8, 9, 10, 1}, 9);
        System.out.println(found);

        found = findValue(new int[]{8, 9, 10, 1, 2, 3}, 2);
        System.out.println(found);
    }

    private static boolean findValue(int[] array, int target) {
        return findValue(array, target, 0, array.length - 1);
    }

    private static boolean findValue(int[] array, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        if (array[start] == target || array[mid] == target || array[end] == target) {
            return true;
        }

        boolean foundIt = false;

        if (array[mid] > array[start] && target < array[mid] && target > array[start]) {
            // go left
            foundIt = findValue(array, target, start, mid - 1);
        } else if (array[end] > array[mid] && target > array[mid] && target < array[end]) {
            // go right
            foundIt = findValue(array, target, mid + 1, end);
        } else if (array[mid] < array[start] && (target > array[start] || target < array[mid])) {
            // go left
            foundIt = findValue(array, target, start, mid - 1);
        } else if (array[end] < array[mid] && (target > array[mid] || target < array[end])) {
            // go right
            foundIt = findValue(array, target, mid + 1, end);
        }

        return foundIt;
    }
}
