public class IsBinarySearchTreeValid {
    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static boolean isBinarySearchTree(BinaryTreeNode root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBinarySearchTree(BinaryTreeNode root, int leftMaximum, int rightMinimum) {

        if (root == null) return true;

        if (root.value < leftMaximum || root.value > rightMinimum) return false;

        return isBinarySearchTree(root.left, leftMaximum, root.value)
                && isBinarySearchTree(root.right, root.value, rightMinimum);
    }


    public static void main(String[] args) {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
        final boolean result = isBinarySearchTree(root);
        System.out.println("result: " + result);

    }
}
