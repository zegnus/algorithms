public class BinaryTreeDiameter {

    public static void main(String[] args) {
        Node n = initialiseTree();

        int[] diameter = new int[]{Integer.MIN_VALUE};

        int height = height(n, diameter);

        System.out.println("height node " + n.value + " is " + height + " and diameter is " + diameter[0]);
    }

    private static int height(Node n, int[] diameter) {
        if (n == null) {
            return 0;
        }

        int leftHeight = height(n.left, diameter);
        int rightHeight = height(n.right, diameter);

        diameter[0] = Math.max(diameter[0], 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static Node initialiseTree() {
        /*
            1
           /\
          2 3
          /\
         4 5

         from 4 -> 3 there are 4 nodes inclusive

         */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

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

        Node(int value) {
            this.value = value;
        }
    }
}
