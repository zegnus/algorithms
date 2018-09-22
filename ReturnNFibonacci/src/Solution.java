public class Solution {

    public static void main(String[] args) {
        int n = 7;
        int fib = fibonacci(n);
        System.out.println("Fibonnaci of " + n + " is " + fib);
    }

    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        int[] sequence = new int[n+1];
        sequence[0] = 0;
        sequence[1] = 1;

        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence[n];
    }
}
