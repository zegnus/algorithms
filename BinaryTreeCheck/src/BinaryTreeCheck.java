public class BinaryTreeCheck {

    public static void main(String[] args) {
        Node node = initializeTree();
        boolean isBinaryTree = isBinaryTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Is binary tree: " + isBinaryTree);
    }

    private static boolean isBinaryTree(Node node, int minimum, int maximum) {
        if (node == null) {
            return true;
        }

        if (node.value < minimum || node.value > maximum) {
            return false;
        }

        boolean isLeftTreeBinary = isBinaryTree(node.left, minimum, node.value);
        boolean isRightTreeBinary = isBinaryTree(node.right, node.value, maximum);

        return isLeftTreeBinary && isRightTreeBinary;
    }

    private static Node initializeTree() {
        /*

           10
           /\
         5   20
         /\  /\
        1 7 15 30

        A node must be more than a minimum and less than a maximum
        Base case when node is null -> true
        False case when a node is < than a minimum or > than a maximum

         */
        Node n10 = new Node(10);
        Node n5 = new Node(5);
        Node n20 = new Node(20);
        Node n1 = new Node(1);
        Node n7 = new Node(7);
        Node n15 = new Node(15);
        Node n30 = new Node(30);

        n10.left = n5;
        n10.right = n20;
        n5.left = n1;
        n5.right = n7;
        n20.left = n15;
        n20.right = n30;

        return n10;
    }

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }
}
