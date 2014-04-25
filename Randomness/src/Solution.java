import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * You’re given a string S of N characters. It’s known that the string consists of lowercase latin letters. The string is generated randomly. That means that every symbol is chosen randomly and independently from others from the set {‘a’, ‘b’, …, ‘z’}. All the letters has equal probability to appear.
 * <p/>
 * You’re given Q queries on this string. Each query is of the form P C, where P is an integer between 1 and N (both inclusive) and C is a character from the set {‘a’, ‘b’, …, ‘z’}. Both P and C were chosen at random and independently from other queries.
 * <p/>
 * When you have a query of the form P C you have to change the Pth symbol of S to C. After every change we ask you to output the number of distinct nonempty sub-strings of S.
 * <p/>
 * Input Format
 * The first line of input consists of two single space separated integers N and Q - the length of the string S and the number of queries respectively.
 * <p/>
 * The second line contains the string S itself.
 * <p/>
 * The following Q lines describe the queries in the form P C, where P and C are also separated with a single space.
 * <p/>
 * Constraints
 * <p/>
 * 4 ≤ N ≤ 75000
 * 4 ≤ Q ≤ 75000
 * <p/>
 * Output Format
 * Output Q lines. Output the number of distinct substrings of S after the ith query on the ith line of the output.
 * <p/>
 * Sample Input
 * <p/>
 * 4 4*
 * aaab
 * 1 a
 * 2 b
 * 3 c
 * 4 d
 * Sample Output
 * <p/>
 * 7
 * 7
 * 9
 * 10
 * Explanation
 * <p/>
 * after replacing the character at 1st index with a, we still have the original string aaab. The total non empty substrings of aaab are
 * <p/>
 * a b aa ab aaa aab aaab
 * hence 7.
 * <p/>
 * after replacing the character at 2nd index with b, we have the string abab. The total non empty substrings of abab are
 * <p/>
 * a b ab ba aba bab abab
 * hence 7.
 * <p/>
 * after replacing the character at 3rd index with c, we have the string abcb. The total non empty substrings of abcb are
 * <p/>
 * a b c ab bc cb abc bcb abcb
 * hence 9.
 * <p/>
 * after replacing the character at 4th index with d, we have the string abcd. The total non empty substrings of abcd are
 * <p/>
 * a b c d ab bc cd abc bcd abcd
 * hence 10.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questionsArray;

        int inputLength = scanner.nextInt();
        int numberQuestions = scanner.nextInt();
        String originalInput = scanner.next();

        questionsArray = new String[numberQuestions];

        int position = scanner.nextInt() - 1;
        String newCharacter = scanner.next();
        questionsArray[0] = new StringBuilder(originalInput).replace(position, position + 1, newCharacter).toString();

        for (int i = 1; i < numberQuestions; i++) {
            position = scanner.nextInt() - 1;
            newCharacter = scanner.next();

            questionsArray[i] = new StringBuilder(questionsArray[i - 1]).replace(position, position + 1, newCharacter).toString();
        }

        Set<String> substrings = new HashSet<String>();

        for (int question = 0; question < numberQuestions; question++) {
            for (int length = 1; length <= inputLength; length++) {
                for (int i = 0; i < inputLength - length + 1; i++) {
                    substrings.add(questionsArray[question].substring(i, i + length));
                }
            }

            System.out.println(substrings.size());
            substrings.clear();
        }
    }
}
