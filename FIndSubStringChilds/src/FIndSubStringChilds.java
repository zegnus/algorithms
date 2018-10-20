public class FIndSubStringChilds {

    public static void main(String[] args) {
        int m = find("abcdef", "fbdann", 0, 0, 0, new int[1]);
        System.out.println(m);

        m = find("SHINCHAN", "NOHARAAA", 0, 0, 0, new int[1]);
        System.out.println(m);

        m = find("AA", "BB", 0, 0, 0, new int[1]);
        System.out.println(m);

        m = find("harry", "sally", 0, 0, 0, new int[1]);
        System.out.println(m);
    }

    private static int find(String a, String b, int aStart, int bStart, int max, int[] maxArray) {
        if (maxArray[0] < max) maxArray[0] = max;

        for (int i = aStart; i < a.length(); i++) {
            int matchIndex = findMatchIndex(a.charAt(i), bStart, b);

            if (matchIndex != -1) {
                find(a, b, i+1, matchIndex+1, max+1, maxArray);
            }
        }

        return maxArray[0];
    }

    private static int findMatchIndex(char match, int start, String input) {
        for (int i = start; i < input.length(); i++) {
            if (input.charAt(i) == match) {
                return i;
            }
        }

        return -1;
    }
}
