public class PalindromePermutation {

    public static void main(String args[]) {
        String input = "Tact Coa";
        boolean isPalindromePermutation = isPalindromePermutation(input.toLowerCase());
        System.out.println(input + " is palindrome permutation: " + isPalindromePermutation);
    }

    private static boolean isPalindromePermutation(String input) {
        int[] numberOfOccurrences = new int[128];
        int lengthOfCharactersWithoutSpaces = 0;

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                lengthOfCharactersWithoutSpaces++;
                numberOfOccurrences[c]++;
            }
        }

        if (lengthOfCharactersWithoutSpaces % 2 == 0) {
            return checkOnlyContainsEvenChars(numberOfOccurrences);
        } else {
            return checkContainsAllEvenCharsButOneChar(numberOfOccurrences);
        }
    }

    private static boolean checkOnlyContainsEvenChars(int[] numberOfOccurrances) {
        for (int count : numberOfOccurrances) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkContainsAllEvenCharsButOneChar(int[] numberOfOccurrences) {
        int numberOfOneCharacters = 0;
        int numberOfOddCharacters = 0;

        for (int count : numberOfOccurrences) {
            if (count == 1) {
                if (numberOfOneCharacters == 1) {
                    return false;
                } else {
                    numberOfOneCharacters++;
                }
            } else if (count % 2 != 0) {
                if (numberOfOddCharacters == 1) {
                    return false;
                } else {
                    numberOfOddCharacters++;
                }
            }
        }

        return (numberOfOneCharacters == 1 && numberOfOddCharacters == 0) ||
                (numberOfOneCharacters == 0 && numberOfOddCharacters == 1);
    }
}
