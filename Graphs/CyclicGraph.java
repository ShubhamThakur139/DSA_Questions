package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class CyclicGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            // number of vertices in a graph
            int n = sc.nextInt();
            // number of edges in a graph
            int m = sc.nextInt();
            // Storing a graph in Adjacency List
            ArrayList<Integer> graph[] = new ArrayList[n + 1];
            // at every index we are giving an array list
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            // taking values of vertices
            for (int i = 0; i < m; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                graph[src].add(dest);
                graph[dest].add(src);
            }

            if (isCycleFormed(graph, n)) {
                System.out.println("Cyclic graph");
            } else {
                System.out.println("Non-Cyclic graph");
            }

        }
        sc.close();
    }

    private static boolean isCycleFormed(ArrayList<Integer>[] graph, int n) {

        boolean isVisited[] = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if (dfs(graph, i, -1, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(ArrayList<Integer>[] graph, int src, int parent, boolean[] isVisited) {
        isVisited[src] = true;

        for (Integer adj : graph[src]) {
            if (isVisited[adj] == true) {
                if (parent != adj)
                    return true;
            } else {
                if (dfs(graph, adj, src, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
