public class LongesCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(lcs("AGGTAB".toCharArray(), "GXTXAYB".toCharArray()) == 4);
        System.out.println(lcs("ABCDGH".toCharArray(), "AEDFHR".toCharArray()) == 3);
    }

    private static int lcs(char[] inputA, char[] inputB) {
        int[][] common = new int[inputA.length + 1][inputB.length + 1];

        for (int a = 0; a <= inputA.length; a++) {
            for (int b = 0; b <= inputB.length; b++) {
                if (a == 0 || b == 0) {
                    common[a][b] = 0;
                } else if (inputA[a - 1] == inputB[b - 1]) {
                    common[a][b] = common[a-1][b-1] + 1;
                } else {
                    common[a][b] = Math.max(common[a-1][b], common[a][b-1]);
                }
            }
        }

        print(inputA, inputB, common);

        return common[inputA.length][inputB.length];
    }

    private static void print(char[] inputA, char[] inputB, int[][] common) {
        int a = inputA.length - 1;
        int b = inputB.length - 1;
        int index = common[a + 1][b + 1] - 1;
        char[] lca = new char[index + 1];

        while (index >= 0) {
            if (inputA[a] == inputB[b]) {
                lca[index] = inputA[a];
                index--;
                a--;
                b--;
            } else if (common[a][b] == common[a][b-1]) {
                b--;
            } else {
                a--;
            }
        }

        System.out.println(lca);
    }
}
