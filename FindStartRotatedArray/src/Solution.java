public class Solution {

    public static void main(String[] args) {
        int head = findHead(new int[]{8, 9, 1, 2, 3, 4, 5});
        System.out.println(head == 1);

        head = findHead(new int[]{8, 9, 1, 2, 3});
        System.out.println(head == 1);

        head = findHead(new int[]{9, 1});
        System.out.println(head == 1);

        head = findHead(new int[]{8, 9, 1});
        System.out.println(head == 1);

        head = findHead(new int[]{8, 9, 10, 1});
        System.out.println(head == 1);

        head = findHead(new int[]{8, 9, 10, 1, 2, 3});
        System.out.println(head == 1);
    }

    private static int findHead(int []array) {
        int start = 0;
        int end = array.length;
        int mid = 0;

        while (start != end) {
            mid = start + (end - start) / 2;

            if (mid == start) {
                mid++;
                break;
            }

            if (array[mid] < array[start]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return array[mid];
    }
}


