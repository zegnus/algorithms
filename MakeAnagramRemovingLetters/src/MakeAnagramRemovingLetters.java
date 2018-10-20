public class MakeAnagramRemovingLetters {

    public static void main(String[] args) {
        System.out.println(makeAnagram("cde", "abc"));
    }

    private static int makeAnagram(String a, String b) {
        int[] frequency = new int['z' - 'a' + 1];

        for (char c : a.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            frequency[c - 'a']--;
        }

        int numberOfLettersToDelete = 0;

        for (int instances : frequency) {
            numberOfLettersToDelete += Math.abs(instances);
        }

        return numberOfLettersToDelete;
    }
}
