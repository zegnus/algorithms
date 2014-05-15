import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ferran on 5/7/14.
 */
public class Solution {

    private static class Pair {
        public Integer a, b;

        public Pair(Integer pA, Integer pB) {
            a = pA;
            b = pB;
        }
    }

    private static int values[];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("CutTheTree/files/input2.txt"));
        //Scanner scanner = new Scanner(System.in);
        int nVertex = scanner.nextInt();
        int total = 0;
        int minimumTotal = Integer.MAX_VALUE;

        values = new int[nVertex];
        for (int i = 0; i < nVertex; i++) {
            int value = scanner.nextInt();
            values[i] = value;
            total += value;
        }

        List[] tree = new LinkedList[nVertex];
        Pair[] cuts = new Pair[nVertex - 1];

        for (int i = 0; i < nVertex; i++) {
            tree[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < nVertex - 1; i++) {
            Integer vertexA = scanner.nextInt() - 1;
            Integer vertexB = scanner.nextInt() - 1;
            cuts[i] = new Pair(vertexA, vertexB);
            tree[vertexA].add(vertexB);
            tree[vertexB].add(vertexA);
        }

        // print
        /*
        for (int i = 0; i < nVertex; i++) {
            System.out.println((i + 1) + " -> " + tree[i].toString());
        }
        */

        System.out.println("total:" + total);

        // cuts

        Integer vertexA;
        Integer vertexB;

        for (int i = 0; i < nVertex - 1; i++) {
            vertexA = cuts[i].a;
            vertexB = cuts[i].b;

            tree[vertexA].remove(vertexB);
            tree[vertexB].remove(vertexA);

            int costLeft = cost(tree, vertexA);
            int costRight = Math.abs(total - costLeft);

            //System.out.println((vertexA + 1) + " " + (vertexB + 1) + " - " + costLeft + " " + costRight + " - " + (Math.abs(costLeft - costRight)));
            int diff = Math.abs(costLeft - costRight);
            if (diff < minimumTotal) {
                minimumTotal = diff;
            }

            tree[vertexA].add(vertexB);
            tree[vertexB].add(vertexA);
        }

        System.out.println(minimumTotal);
    }

    private static int cost(List[] pTree, int pVertex) {
        boolean[] visited = new boolean[pTree.length];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addAll(pTree[pVertex]);

        int cost = values[pVertex];
        visited[pVertex] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (!visited[vertex]) {
                visited[vertex] = true;
                cost += values[vertex];
                queue.addAll(pTree[vertex]);
            }
        }

        return cost;
    }
}

