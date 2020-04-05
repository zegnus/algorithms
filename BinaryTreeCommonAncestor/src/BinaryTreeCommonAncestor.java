public class BinaryTreeCommonAncestor {

    public static void main(String[] args) {
        /*
            1
           /\
          2 3
          /\
         4 5

         common ancestor between node 4 and 5 is 2

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

        Node commonAncestor = commonAncestor(n1, 4, 5);

        System.out.println("Common ancestor between node 4 and node 5 is " + commonAncestor.value);
    }

    private static Node commonAncestor(Node node, int value1, int value2) {
        if (node == null) {
            return null;
        }

        if (node.value == value1 || node.value == value2) {
            return node;
        }

        Node left = commonAncestor(node.left, value1, value2);
        Node right = commonAncestor(node.right, value1, value2);

        if (left != null && right != null) {
            return node;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }
}
