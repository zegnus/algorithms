public class URLify {

    public static void main(String args[]) {
        String input = "Mr John  Smith   ";
        int length = 13;

        String urlify = urlify(input, length);
        System.out.println(urlify);
    }

    private static String urlify(String input, int inputLength) {
        char[] chars = input.toCharArray();

        int targetIndex = chars.length - 1;
        int initialIndex = initialIndex(chars);

        for (int i = initialIndex; i >= 0; i--) {
            if (chars[i] != ' ') {
                chars[targetIndex] = chars[i];
                targetIndex--;
            } else {
                if (chars[i+1] != ' ') {
                    chars[targetIndex] = '0';
                    chars[targetIndex-1] = '2';
                    chars[targetIndex-2] = '%';
                    targetIndex -= 3;
                }
            }
        }

        return new String(chars);
    }

    private static int initialIndex(char[] input) {
        int index = input.length - 1;

        while (input[index] == ' ') {
            index--;
        }

        return index;
    }
}
