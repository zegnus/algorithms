import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by ferran on 4/29/14.
 */
public class Solution {
    private static class Pair {
        private final int a;
        private final int b;

        public Pair(int pA, int pB) {
            a = pA;
            b = pB;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            return a == pair.a && b == pair.b
                    || a == pair.b && b == pair.a;
        }

        @Override
        public int hashCode() {
            return (31 * a + b) + (31 * b + a);
        }

        @Override
        public String toString() {
            return a + "-" + b;
        }
    }

    private static class Node {
        public final int value;
        public final int depth;
        public Node left;
        public Node right;

        public Node(int pValue, int pDepth) {
            value = pValue;
            depth = pDepth;
        }
    }

    public static Node root = null;
    public static Map<Pair, Integer> mCost = new HashMap<Pair, Integer>();

    public static int[] mParent;
    public static Set<Integer> nodesValue = new HashSet<Integer>();

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("BSTmaintenance/files/input.txt"));
            int numberOfNodes = scanner.nextInt() + 1;

            mParent = new int[numberOfNodes];

            for (int i = 0; i < numberOfNodes - 1; i++) {
                add(scanner.nextInt());
                //System.out.println(getAllCosts());
            }

            BFS(root);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("time:" + (System.currentTimeMillis() - time));
    }

    private static int getAllCosts() {
        int total = 0;

        Set<Pair> pairs = mCost.keySet();
        for (Pair pair : pairs) {
            total += mCost.get(pair);
        }

        return total;
    }

    private static void add(int pValue) {
        root = add(root, pValue, 0);

        // calculate costs from newNodeValue to all other costs
        /*
        int parentNode = mParent[pValue];

        for (Integer value : nodesValue) {
            if (parentNode != value) {
                mCost.put(new Pair(pValue, value), 1 + mCost.get(new Pair(mParent[pValue], value)));
            }
        }

        nodesValue.add(pValue);
        */
    }

    private static Node add(Node pNode, int pValue, int pDepth) {
        if (pNode == null) {
            pNode = new Node(pValue, pDepth);
            mCost.put(new Pair(pValue, pValue), 0);
        } else {
            int newNodeValue = 0;

            if (pValue < pNode.value) {
                pNode.left = add(pNode.left, pValue, pDepth+1);
                newNodeValue = pNode.left.value;
            } else if (pValue > pNode.value) {
                pNode.right = add(pNode.right, pValue, pDepth+1);
                newNodeValue = pNode.right.value;
            }

            mParent[newNodeValue] = pNode.value;
            mCost.put(new Pair(newNodeValue, pNode.value), 1);
        }

        return pNode;
    }

    private static void BFS(Node pNode) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(pNode);

        int currentLevel = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            System.out.print(n.value + " D:" + n.depth + " ");

            currentLevel--;

            if (null != n.left) {
                nextLevel++;
                queue.add(n.left);
            }

            if (null != n.right) {
                nextLevel++;
                queue.add(n.right);
            }

            if (currentLevel == 0) {
                System.out.println();

                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }


}
