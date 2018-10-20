import java.util.*;

public class AllStringPermutationsRecursive {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(getPermutationsSimple("catscatscatscatscats", new HashMap<String, Set<String>>()));
        System.out.println(System.currentTimeMillis() - time);
    }

    private static Set<String> getPermutationsSimple(String inputString, Map<String, Set<String>> memory) {
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        } else {
            Set<String> set = new HashSet<>();

            for (int i = 0; i < inputString.length(); i++) {
                String substring = inputString.substring(0, i) + inputString.substring(i + 1);

                Set<String> permutations = memory.get(substring);
                if (permutations == null) {
                    permutations = getPermutationsSimple(inputString.substring(0, i) + inputString.substring(i + 1), memory);
                    memory.put(substring, permutations);
                }

                for (String permutation : permutations) {
                    set.add(inputString.charAt(i) + permutation);
                }
            }

            return set;
        }
    }
}
