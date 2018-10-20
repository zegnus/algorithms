/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just  character at  index in the string, and the remaining characters will
 * occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 *
 */
public class SherlockValidString {

    public static void main(String[] args) {
        System.out.println(isValid("aabb") == true);
        System.out.println(isValid("aaabbcc") == true);
        System.out.println(isValid("aahhfff") == true);
        System.out.println(isValid("aab") == true);
        System.out.println(isValid("aaabb") == true);
        System.out.println(isValid("abcdefghhgfedecba") == true);
        System.out.println(isValid("abbac") == true);
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd") == true);

        System.out.println(isValid("aabbcd") == false);
        System.out.println(isValid("aabbccddeefghi") == false);
        System.out.println(isValid("xxxaabbccrry") == false);
    }

    private static boolean isValid(String input) {
        int[] freq = new int['z' - 'a' + 1];

        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i) - 'a']++;
        }

        int baseFrequencyQuantity = 0;
        int otherFrequencyQuentity = 0;
        int baseFrequency = 0;
        int otherFrequency = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {

                if (baseFrequency == 0 || baseFrequency == freq[i]) {
                    baseFrequency = freq[i];
                    baseFrequencyQuantity++;
                    continue;
                }

                if (otherFrequency == 0 || otherFrequency == freq[i]) {
                    otherFrequency = freq[i];
                    otherFrequencyQuentity++;
                    continue;
                }

                return false;
            }
        }

        if (otherFrequency == 0) {
            return true;
        }

        if (baseFrequencyQuantity == 1 || otherFrequencyQuentity == 1) {
            return true;
        }

        return false;
    }
}
