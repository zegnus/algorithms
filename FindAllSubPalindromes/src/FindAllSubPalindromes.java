public class FindAllSubPalindromes {

    public static void main(String[] args) {
        System.out.println(numberOfSubSpecialPalindromes("asasd") == 7);
        System.out.println(numberOfSubSpecialPalindromes("abcbaba") == 10);
        System.out.println(numberOfSubSpecialPalindromes("aabaa") == 9);
        System.out.println(numberOfSubSpecialPalindromes("aaaa") == 10);
    }

    private static int numberOfSubSpecialPalindromes(String input) {
        int numPal = input.length();

        for (int i = 0; i < input.length(); i++) {

            int indexDifferentCharacter = -1;

            for (int j = i+1; j < input.length(); j++) {

                if (input.charAt(i) == input.charAt(j)) {
                    boolean distanceBetweenStartAndEndIsTheSame = j - indexDifferentCharacter == indexDifferentCharacter - i;
                    if (indexDifferentCharacter == -1 || distanceBetweenStartAndEndIsTheSame) {
                        numPal++;
                    }
                } else {
                    if (indexDifferentCharacter == -1) {
                        indexDifferentCharacter = j;
                    } else {
                        break;
                    }
                }

            }
        }

        return numPal;
    }
}
