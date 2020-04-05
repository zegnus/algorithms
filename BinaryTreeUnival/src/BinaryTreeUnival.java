public class BinaryTreeUnival {
    public static void main(String args[]) {
        Node n = initialiseTree();

        System.out.println(isUnival(n));
    }

    private static boolean isUnival(Node n) {
        int[] subtrees = new int[1];
        boolean univalRecursive = isUnivalRecursive(n, n.value, subtrees);
        System.out.println("number of unival subtrees: " + subtrees[0]);
        return univalRecursive;
    }

    private static boolean isUnivalRecursive(Node n, int referenceValue, int[] subtrees) {
        if (n == null) {
            return true;
        }

        if (n.value != referenceValue) {
            return false;
        }

        boolean isUnivalLeft = isUnivalRecursive(n.left, referenceValue, subtrees);
        boolean isUnivalRight = isUnivalRecursive(n.right, referenceValue, subtrees);

        if (isUnivalLeft && isUnivalRight) subtrees[0]++;

        return isUnivalLeft && isUnivalRight;
    }

    private static Node initialiseTree() {
        Node n1 = new Node(0);
        Node n2 = new Node(0);
        Node n3 = new Node(0);
        Node n4 = new Node(0);
        Node n5 = new Node(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        return n1;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
